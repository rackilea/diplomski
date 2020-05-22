if (event.getSource() == copyButton) {
        Path sourcePath = selectedSourceFile.toPath();
        Path destinationPath = selectedDestinationFile.toPath();
        try {
            Files.copy(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }