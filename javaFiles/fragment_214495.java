Scanner sc = new Scanner(System.in);
String str = "b5l*a+i";

// This pattern could be declared as a constant
// It matches any sequence of alpha characters
Pattern pattern = Pattern.compile("[a-zA-Z]+");

Matcher matcher = pattern.matcher(str);

StringBuffer result = new StringBuffer();

// For each match ...
while(matcher.find()) {
    // matcher.group() returns the macth found
    System.out.println("Enter value for "+ matcher.group());

    Integer input = sc.nextInt();

    // ... append the parsed string with replacement of the match ...
    matcher.appendReplacement(result, input.toString());
}

// ... and don't forget to append tail to add characters that follow the last match 
matcher.appendTail(result);

System.out.println(result);