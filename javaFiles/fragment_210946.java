String outText="";
String inText="Sony Ericsson is a leading company in mobile. " +
              "The company sony ericsson was found in oct 2001";
String word = "sony ericsson";
outText = inText.replaceAll("(?i)" + word, word.replaceAll(" ", "~"));
System.out.println(outText);