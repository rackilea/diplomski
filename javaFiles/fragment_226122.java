public void deleteRecursive(File fileOrDirectory) {

        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                if (child.getName().equals("myfile40")) {

                    System.out.println("File 40 - Not deleted");
                } else {
                    deleteRecursive(child);
                }
        }

        fileOrDirectory.delete();


    }