public static String currenttxt() throws IOException {

       try (BufferedReader br = new BufferedReader(new FileReader(file))) {
       StringBuilder b = new StringBuilder();
         try {

            String line = br.readLine();
            while (line != null) {
               b.append(line);
               b.append(System.getProperty("line.separator"));
               line = br.readLine();
            }

         } catch (Exception e) {
            e.printStackTrace();
            throw e;
         }

         // remove the last line separator at the end using trim()
         return b.toString().trim();
       }