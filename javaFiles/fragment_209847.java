private static void loadOpenCVLibrary() {
        //all opencv libs must be copyed to OpenCV_lib in the project workspace
        File folder = new File("OpenCV_lib/");
        File[] listOfFiles = folder.listFiles(); 

    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".dylib")) {
            File lib = new File("OpenCV_lib/" + listOfFiles[i].getName());
            System.load(lib.getAbsoluteFile().toString());
        }
    }
}