String newname = mixCase(listOfFiles[i].getName());
    File renamedFile = new File(folder, newname);
    if (listOfFiles[i].renameTo(renamedFile )) {
        String extension = FilenameUtils
                .getExtension(listOfFiles[i].getName());
        if (extension.equals("txt") || extension.equals("pdf")
                || extension.equals("docx")
                || extension.equals("log")) {
            rewrite(renamedFile);

            System.out.println("Done");
        }

    }