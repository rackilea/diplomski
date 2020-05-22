try {

      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       Date date = dateFormat.parse("11/12/2017")
     }
    catch (ParseException ex){
        Log.i("Current Date","error occurred while parsing date");
     }