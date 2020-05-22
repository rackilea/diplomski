String abc="123XXXXX0";

    ArrayList<String> lstValues = new ArrayList<String>();
    lstValues.add("111XXXX1");
    lstValues.add("122XXX1");
    lstValues.add("123XXXX1");

      for (int i=0;i<lstValues.size();i++){
          String value=lstValues.get(i);
          if(value.substring(0,3).equals(abc.substring(0,3))){
             System.out.println("Found");
          }
          else {
           System.out.println("Not Found");   
          }
      }