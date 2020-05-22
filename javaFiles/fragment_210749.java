try {
        File file = new File("../../FXMLDocument.fxml");
        if (file.canRead()) {
            URL url = file.toURI().toURL();
            Pane root = FXMLLoader.load(url);
        } else {
            System.err.println("File does not exist.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }