File testDoc = new File("C:\\Users\\Te\\Documents\\TestDocument.txt");
        BufferedReader reader = new BufferedReader(new FileReader(testDoc));
        try {
             String line = "";
             while((line =reader.readLine()) != null) {
                 System.out.println(line);
             }
        } finally {
          reader.close();
        }