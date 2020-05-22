String[] newText = Name.split("\",\""); //it returns an array of strings
for (int i=0; i<newText.length; i++)
    newText[i] = newText[i].replace("\"", "").replace(":", ". ");
Arrays.sort(newText);
String ultimateText = "";
for (String s : newText)
    ultimateText = ultimateText+s+"\n";
Name.setText(ultimateText);