LocalDateTime date = LocalDateTime.now();
String dateFormatString = "dd/MM/yyyy H:m:s";
System.out.println("Old Format: \"" + dateFormatString + "\" = " + 
    date.format(DateTimeFormatter.ofPattern(dateFormatString)));
Pattern p = Pattern.compile("(?:[^My]*)([My]+[^\\w]*[My]+)(?:[^My]*)");
Matcher m = p.matcher(dateFormatString);
if(dateFormatString.contains("y") && dateFormatString.contains("M") && m.matches())
{
    dateFormatString = m.group(1);
    System.out.println("New Format: \"" + dateFormatString + "\" = " + 
        date.format(DateTimeFormatter.ofPattern(dateFormatString)));
}
else
{
    throw new IllegalArgumentException("Couldn't shorten date format string!");
}