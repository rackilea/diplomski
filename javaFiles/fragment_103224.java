public static void listFilesForFolder(final File folder) throws IOException, InterruptedException
    {
            File file = new File("F:\\nitish\\out.txt"); //Your file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    System.out.println("Directory:" + fileEntry.getName());
                    writer.write("Directory:\t" + fileEntry.getName());
                    writer.flush();
                    listFilesForFolder(fileEntry);
                } else {
                    int len = fileEntry.getName().length();
                    writer.write(fileEntry.getName().substring(0, len-4));
                    writer.flush();
                    System.out.println("\t" + fileEntry.getName().substring(0, len-4));
                }

           }
           writer.close();
    }