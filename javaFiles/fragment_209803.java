String DATE_FORMAT_NOW = "dd MMM hh:mm:ss yyyy";
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
String stringDate = sdf.format(date );
System.out.println("FirstDate : "+stringDate);
try {
    Date date2 = sdf.parse(stringDate);
    System.out.println(date2);
    } catch(ParseException e){
      //Exception handling
       } catch(Exception e){
         //handle exception
       }