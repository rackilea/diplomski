Pattern numberPat = Pattern.compile("\\d+");
Matcher matcher1 = numberPat.matcher(line);

Pattern stringPat = Pattern.compile("What is the square of", Pattern.CASE_INSENSITIVE);
Matcher matcher2 = stringPat.matcher(line);

if (matcher1.find() && matcher2.find())
{
    int number = Integer.parseInt(matcher1.group());                    
    pw.println(number + " squared = " + (number * number));
}