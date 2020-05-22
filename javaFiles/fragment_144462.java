String untrimmed = "  some   string   ";
String trimmed = "";

String innerSpaces = "";
boolean wordBoundary = true;

try {
    for (int i = 0; ; i++) {
        String substr = untrimmed.substring(i, i + 1);

        if (!substr.equals(" ") && !substr.equals("\t") && 
               !substr.equals("\n") && !substr.equals("\r")) {

            trimmed += innerSpaces + substr;
            wordBoundary = false;
            innerSpaces = "";
        }
        else if (!wordBoundary) {
            innerSpaces += substr;
        }
    }
}
catch (IndexOutOfBoundsException e)  { }

System.out.println(trimmed);