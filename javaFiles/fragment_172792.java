String line = "Bygholm Søpark 21B";
String pattern = "\\A\\s*\r\n" + 
  "(?: #########################################################################\r\n" + 
  "    # Option A: [<Addition to address 1>] <House number> <Street name>      #\r\n" + 
  "    # [<Addition to address 2>]                                             #\r\n" + 
  "    #########################################################################\r\n" + 
  "    (?:(?<AAdditiontoaddress1>.*?),\\s*)?         # Addition to address 1\r\n" + 
  "(?:No\\.\\s*)?\r\n" + 
  "    (?<AHousenumber1>\\pN+[a-zA-Z]?(?:\\s*[-/\\pP]\\s*\\pN+[a-zA-Z]?)*) # House number\r\n" + 
  "\\s*,?\\s*\r\n" + 
  "    (?<AStreetname1>(?:[a-zA-Z]\\s*|\\pN\\pL{2,}\\s\\pL)\\S[^,\\#]*?(?<!\\s)) # Street name\r\n" + 
  "\\s*(?:(?:[,/]|(?=\\#))\\s*(?!\\s*No\\.)\r\n" + 
  "    (?<AAdditiontoaddress2>(?!\\s).*?))?              # Addition to address 2\r\n" + 
  "|   #########################################################################\r\n" + 
  "    # Option B: [<Addition to address 1>] <Street name> <House number>      #\r\n" + 
  "    # [<Addition to address 2>]                                             #\r\n" + 
  "    #########################################################################\r\n" + 
  "    (?:(?<BAdditiontoaddress1>.*?),\\s*(?=.*[,/]))?   # Addition to address 1\r\n" + 
  "    (?!\\s*No\\.)(?<BStreetname>\\S\\s*\\S(?:[^,\\#](?!\\b\\pN+\\s))*?(?<!\\s)) # Street name\r\n" + 
  "\\s*[/,]?\\s*(?:\\sNo\\.)?\\s+\r\n" + 
  "    (?<BHousenumber>\\pN+\\s*-?[a-zA-Z]?(?:\\s*[-/\\pP]?\\s*\\pN+(?:\\s*[-a-zA-Z])?)*|[IVXLCDM]+(?!.*\\b\\pN+\\b))(?<!\\s) # House number\r\n" + 
  "\\s*(?:(?:[,/]|(?=\\#)|\\s)\\s*(?!\\s*No\\.)\\s*\r\n" + 
  "    (?<BAdditiontoaddress2>(?!\\s).*?))? # Addition to address 2\r\n" + 
  ")\r\n" + 
  "\\s*\\Z";

// Create a Pattern object
Pattern r = Pattern.compile(pattern, Pattern.COMMENTS);
// Now create a matcher object.
Matcher m = r.matcher(line);
if (m.find()) {
    System.out.println("B_Street_name: " + m.group("BStreetname") );
    System.out.println("B_House_number: " + m.group("BHousenumber") );
    System.out.println("B_Addition_to_address_2: " + m.group("BAdditiontoaddress2") );
} else {
    System.out.println("NO MATCH");
}