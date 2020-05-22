try (Stream<Path> files = Files.list(new File("/tmp").toPath())) {
        files.filter(p -> p.getFileName().toString().endsWith(".crc"))
                .filter(p -> p.toFile().length() > 0)
                .filter(p -> Files.isRegularFile(p))
                .forEach(filePath -> {
                    Log.info("Size of file B :: " + String.valueOf(filePath.toFile().length()));
                });
    } catch (IOException ex) {
        Log.error("IOE");
    }