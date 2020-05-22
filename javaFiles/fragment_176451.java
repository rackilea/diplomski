File tempFile = new File(file.getAbsolutePath()+ ".tmp");
 try (BufferedReader br = new BufferedReader(new FileReader(inFile));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {
     String registerUser;
     while ((registerUser = br.readLine()) != null) {
        if (!registerUser.contains(removeuser)) {
            pw.println(line);
        }
     }
 }
 if (!inFile.delete()) {
     System.out.println("Could not delete file");
 } else if (!tempFile.renameTo(inFile))
     System.out.println("Could not rename file");
 }