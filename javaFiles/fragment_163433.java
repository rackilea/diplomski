Document document = documentpane.getDocument();
String content = document.getText(0, document.getLength());
String outputText = "";
for (int i = 0; i < content.length(); i++) {
    Character c = new Character(content.charAt(i));
    if (!special.contains(c))
       outputText += c;
    else
       outputText += " ";
}
System.out.println(outputText);