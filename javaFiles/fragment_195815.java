public static void main(String[] args) {
        String path = "C:\\Users\\abc\\some";
        File folder = new File(path);
        File[] files = folder.listFiles();
        String fileName;
        int lastPeriodPos;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                fileName = files[i].getName();
                lastPeriodPos = fileName.lastIndexOf('.');
                if (lastPeriodPos > 0)
                fileName = fileName.substring(0, lastPeriodPos);
                System.out.println("File name is " + fileName);
            }
        }
    }