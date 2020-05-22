CreateJarPackage zipper = new CreateJarPackage();

    System.out.println(baseline + unique_directory  + "/" + out_jar_file);
    System.out.println(baseline + unique_directory + "/out/");
    System.out.println(baseline.length() + unique_directory.length() + 5);

    try {
        zipper.addZipFiles(baseline + unique_directory + "/" + out_jar_file, baseline + unique_directory + "/out/", baseline.length() + unique_directory.length() + 5);
    } catch (Throwable e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    File folder = new File(baseline + unique_directory + "/out/");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isDirectory()) {

            try {
                zipper.addZipFiles(baseline + unique_directory  + "/" + out_jar_file, listOfFiles[i].toString(), baseline.length() + unique_directory.length() + 5);
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }