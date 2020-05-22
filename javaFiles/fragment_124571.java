final SimpleDateFormat parsedDate = new SimpleDateFormat("yyyy-MM-dd");

final Date date;
try{ 
    date = parsedDate.parse(stringValue); 
} catch(Exception e) {
    // handle the exception.
}