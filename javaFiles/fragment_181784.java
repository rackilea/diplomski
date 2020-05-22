public void listFiles(String directoryName){

        File directory = new File(directoryName);

        //get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList){

           if (file.isFile()){

             System.out.println(file.getName());

           }

        }

   }