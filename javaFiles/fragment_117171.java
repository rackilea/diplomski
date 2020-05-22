@Service
public class DogRestoreServiceImpl extends ContextLoaderListener implements DogRestoreService {

    @Value("${dog.backup.file}")
    private String dogLikesFile;

    private static final int FIELD_ID = 0;
    private static final int FIELD_BREED_TYPE = 1;
    private static final int FIELD_IMG_URL = 2;
    private static final int FIELD_LIKES = 3;
    private static final String DELIMITER = "_!_";

    private final DogRepository dogRepository;

    public DogRestoreServiceImpl(final DogRepository dogRepository) {
        this.dogRepository = requireNonNull(dogRepository, "dogRepository must not be null!");
    }

    @Override
    public void restore() throws IOException {
        final Path path = Paths.get(this.dogLikesFile);
        if (!Files.exists(path)) {
            System.out.println("nothing to restore");
            return;
        }
        final File dogLikesFile = path.toFile();
        final Set<Dog> dogs = new HashSet<>();
        String line;
        try (final BufferedReader reader = new BufferedReader(new FileReader(dogLikesFile))) {
            while ((line = reader.readLine()) != null) {
                final String[] fields = line.split(DELIMITER);
                final Dog dog = new Dog.DogBuilder(Long.parseLong(fields[FIELD_ID]))
                    .breedType(fields[FIELD_BREED_TYPE])
                    .imgUrl(fields[FIELD_IMG_URL])
                    .likes(Long.parseLong(fields[FIELD_LIKES]))
                    .build();
                dogs.add(dog);
            }
            this.dogRepository.save(dogs);
        }
    }

    @Override
    public void contextInitialized(final ServletContextEvent event) {
        try {
            System.out.println("context initialized. restoring data...");
            this.restore();
            System.out.println("data restoring completed!");
        } catch (final IOException ioException) {
            ioException.printStackTrace();
        }
    }
}