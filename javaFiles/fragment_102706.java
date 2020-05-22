private Date modifyDateLayout(String inputDate){ 
    SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd+HH:mm");  
    try {  
        Date date = format.parse(inputDate);  
        Log.i("date: ", date.toString());
        return date;
    } catch (ParseException e) {  
        Log.i("error ParseException : ", e.toString());
        return null;
    }
}