public static File checkifImageExists(String imagename) {
        File file = ImageStorage.getImage("/" + imagename);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }