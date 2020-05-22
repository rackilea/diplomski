String dtStart = "2010-10-15T09:27:37Z";  
SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");  
try {  
    Date date = format.parse(dtStart);  
    System.out.println(date);  
} catch (ParseException e) {  
    e.printStackTrace();  
}