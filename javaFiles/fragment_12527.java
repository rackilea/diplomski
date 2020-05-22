public static void main(String[] args) throws IOException {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

        try (Stream<Path> filesStream = Files.list(Paths.get("/tmp/stackoverflow-files"))) {
            List<String> files = filesStream.map(Path::getFileName)
                    .map(Path::toString)
                    .map(filename -> new Pair<>(filename, filename.substring(40).replace(".java", "")))// The hash seems to be fixed of size 40
                    .map(fileAndDate -> new Pair<>(fileAndDate.getKey(), LocalDate.parse(fileAndDate.getValue(), dateFormatter)))
                    .sorted(Comparator.comparing(Pair::getValue))
                    .map(Pair::getKey)
                    .collect(Collectors.toList());
            System.out.println(files);
        }
    }