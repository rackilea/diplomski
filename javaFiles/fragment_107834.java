String myPDF = ToText();
int rentIndex = myPDF.indexOf("Rent")+"Rent".length();
String rent = myPDF.substring(rentIndex); //Find 1st occurrence of "Rent" and get info after it
rent = rent.substring(int beginIndex, int endIndex); //Get endIndex-beginIndex characters after rent. (I assume you only want like a few numbers afterwards or something.)
//process rent e.g. Integer.parseInt(rent) or something

rentIndex = myPDF.indexOf("Rent",rentIndex)+"Rent".length();
rent = myPDF.substring(rentIndex); //Next occurrence of "Rent"
//Repeat to find the next occurrence, and the one after that. (Until rentIndex gets set to a negative, indicating that no more occurrences exist.)