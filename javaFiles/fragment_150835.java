SimpleDateFormat myFormat = new SimpleDateFormat("MMMM_yyyy");
Date aDate;
try 
{
    aDate = myFormat.parse("January_2009");
} 
catch (ParseException e) 
{
    // Error handling
}