String inputString = "<html><img id=\"MathMLEq1\" style=\"vertical-align: middle;\" src=\"/SOCH/img.PNG\" alt=\"\"/></html>";
StringBuffer q= new StringBuffer(inputString);
String add = "file:///mnt/sdcard";
int separatedInd = inputString.indexOf("/SOCH"); //Get the index of occurrence of the folder name in input string, which I assume remains same
q = q.insert(separatedInd ,add); //Insert your String at that index( before start of /SOCH)
String result = q.toString();  // Contains the new final string which you require