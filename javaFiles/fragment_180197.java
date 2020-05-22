try (BufferedReader  bufferedReader = 
             new BufferedReader(new FileReader(new File(file,FILENAME)));) {
              String readLine = bufferedReader.readLine();
              //do stuff   
      } catch(Exception e) {
           throw e; 
     }