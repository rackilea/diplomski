String symbol;
String name;
String xmlData = "ACE - ACE Limited";
String[] splitData = xmlData.split(" - ");
symbol = splitData[0];
// Set the name to the remaining items
for (int i=1; i<splitData.length; i++) {
    name += splitData[i] + " - ";
}