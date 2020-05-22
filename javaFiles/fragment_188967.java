public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        Path input = main.getInputPath(args);
        Path output = main.getOutputPath(args);

        main.extract(input, output);
        main.flatten(output);
    }

    private final Path getInputPath(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Usage: Main <inputFile> [<outputDirectory>]");
        }

        Path input = Paths.get(args[0]);

        if (!isRegularFile(input)) {
            throw new IllegalArgumentException(String.format("%s is not a file.", input.toFile().getAbsolutePath()));
        }

        return input;
    }

    private final Path getOutputPath(String[] args) throws IOException {
        return args.length < 2 ? Files.createTempDirectory(null) :
                Files.createDirectories(Paths.get(args[1]));
    }

    private final void extract(Path input, Path output) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(input.toFile()))) {
            for (ZipEntry ze = zis.getNextEntry(); ze != null; ze = zis.getNextEntry()) {
                String fileName = ze.getName();

                if (fileName.contains("__MACOSX")) {
                    continue;
                }

                File file = new File(output.toFile(), fileName);

                if (ze.isDirectory()) {
                    Files.createDirectories(file.toPath());
                    continue;
                }

                System.out.println("Extracting: " + file.getAbsolutePath());

                try (FileOutputStream fos = new FileOutputStream(file, true)) {
                    byte[] buffer = new byte[4096];
                    for (int len = zis.read(buffer); len > 0; len = zis.read(buffer)) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    private final void flatten(Path output) throws IOException {
        List<Path> children = Files.list(output)
                .collect(toList());

        if (children.size() == 1) {
            Path path = children.get(0);
            Files.list(path)
                    .forEach(f -> {
                        try {
                            System.out.printf("Moving %s to %s.\n", f.toFile().getAbsolutePath(),
                                    output.toFile().getAbsolutePath());
                            Files.move(f, Paths.get(output.toFile().getAbsolutePath(), f.toFile().getName()));
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });

            Files.delete(path);
        }
    }
}