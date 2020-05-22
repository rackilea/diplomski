FileInputStream finput = new FileInputStream(myFile);
                    String encoding = getInputEncoding(finput);
                    Log.d("Encoding: ", "> " + encoding);


public String getInputEncoding(FileInputStream finput){
      String encoding = "";
      if(finput!=null){

          try{
          BufferedReader myReader = new BufferedReader(new InputStreamReader(finput));
          String getline = "";
          getline = myReader.readLine();
          myReader.close();
          Log.d("Line: ", "> " + getline);

            String[] separated = getline.split("encoding=\"");
            String encoding1 = separated[1];
            String[] separated2 = encoding1.split("\"");
            encoding = separated2[0];

        } catch (Exception e) {

        }

      }
      return encoding;
    }