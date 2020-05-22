String noNewLines = "Hi there, click here http://www.google.com ok?";
String newLines = "Hi there, \r\nclick here \nhttp://www.google.com ok?";
// This is a String format with two String variables. 
// They will be replaced with the desired values once the "format" method is called.
String replacementFormat = "<a href=\"%s\">%s</a>";
// The first round brackets define a group with anything starting with
// "http(s)". The second round brackets delimit that group by a lookforward reference
// to whitespace. 
String pattern = "(http(s)?://.+?)(?=\\s)";
noNewLines = noNewLines.replaceAll(
        pattern,
        // The "$1" literals are group back-references. 
        // In our instance, they reference the group enclosed between the first
        // round brackets in the "pattern" String. 
        new Formatter().format(replacementFormat, "$1", "$1")
        .toString()
);
System.out.println(noNewLines);
System.out.println();
newLines = newLines.replaceAll(
        pattern,
        new Formatter().format(replacementFormat, "$1", "$1")
        .toString()
);
System.out.println(newLines);