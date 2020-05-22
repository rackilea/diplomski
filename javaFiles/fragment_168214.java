public static String convertDateToStringDMY(String input) throws ParseException{
      SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
      SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
      String temp,result;    
      if(input!=null){
      Date date = df2.parse(input);
      temp = df1.format(date);
      result = temp;
      }
      else{
          result = "";
      }
      return result;
    }