public void processEventFile(String fileName) {
     String line;
     String[] split;
     BufferedReader reader = null;
     try {
          reader = new BufferedReader(new FileReader(fileName));
          while((line = reader.readLine()) != null) {
               split = line.split("\\|");
               flightQueue.add(new Flight(split[0], split[1], split[2]));
          }
     } catch(IOException e) {
          e.printStackTrace();
     } finally {
          if(reader != null) {
               try {
                    reader.close();
               } catch(IOException e) {
                    e.printStackTrace();
               }
          }
     }
}