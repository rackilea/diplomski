public void writeToFile()
      {
      try{
      FileWriter fstream = new FileWriter("out.txt");
      BufferedWriter out = new BufferedWriter(fstream);
      for(int i=0;i<array.length;i++){
            out.write(array[i].getBytes());
      }
      out.close();
      }catch (Exception e){
      System.err.println("Error: " + e.getMessage());
      }