@Service
public class DogBackupServiceImpl implements DogBackupService {

    @Value("${dog.backup.file}")
    private String dogLikesFile;

    private static final String DELIMITER = "_!_";

    @Override
    public void backup(final Dog dog) throws IOException {
        final Path dogLikesPath = Paths.get(this.dogLikesFile);
        if (!Files.exists(dogLikesPath)) {
            Files.createDirectories(dogLikesPath.getParent());
            Files.createFile(dogLikesPath);
        }
        final File dogLikesFile = Paths.get(this.dogLikesFile).toFile();
        final StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        String oldLine = null;
        try (final Scanner scanner = new Scanner(dogLikesFile)) {
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine().trim();
                stringBuilder.append(currentLine);
                if (currentLine != null && !currentLine.isEmpty()) {
                    stringBuilder.append("\n");
                }
                if (currentLine != null && currentLine.startsWith(Long.toString(dog.getId()))) {
                    oldLine = currentLine;
                }
            }
        }
        String content = stringBuilder.toString();
        final boolean firstLike = (oldLine == null || oldLine.isEmpty());
        final String updateLine = dog.getId() + DELIMITER + dog.getBreedType() + DELIMITER + dog.getImgUrl() + DELIMITER + dog.getLikes();
        if (!firstLike) {
            content = content.replace(oldLine, updateLine);
        }
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dogLikesFile))) {
            bufferedWriter.write(content);
            if (firstLike) {
                bufferedWriter.write(updateLine);
            }
            bufferedWriter.close();
        }
    }
}