public static boolean checkifImageExists(String imagename) { 
        File file = ImageStorage.getImage("/" + imagename);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }  
    }