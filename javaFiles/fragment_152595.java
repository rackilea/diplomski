File selectedFile = chooser.getSelectedFile();

        try {
            String fileName = selectedFile.getCanonicalPath();
            if (!fileName.endsWith(EXTENSION)) {
                selectedFile = new File(fileName + EXTENSION);
            }
            ImageIO.write(image, FORMAT_NAME, selectedFile);
        } catch (IOException e) {
            e.printStackTrace();