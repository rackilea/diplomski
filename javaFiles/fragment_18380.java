String input = "12345";
java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(".*[^0-9].*");

if( pattern.matcher(input).matches() )
    System.out.println("Its a number");
else
    System.out.println("Its not a number");