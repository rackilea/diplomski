try{
      FileInputStream fstream = new FileInputStream("data.dat");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;
      while ((strLine = br.readLine()) != null)   {
       if (strLine.startsWith("Give your data0 here")){

                        String delimiter = "|";
                        temp = str.split(delimiter);
                        for(int i =0; i < temp.length ; i++) {
                          System.out.println(temp[i]); //you will get data here
                        }
       }
      }
      in.close();
      }catch (Exception e){
          System.err.println("Error: " + e.getMessage());
      }