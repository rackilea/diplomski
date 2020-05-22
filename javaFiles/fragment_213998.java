ArrayList<Integer> arrayList = new ArrayList<Integer>();
// Assuming three times here
String inputString = "<html><img id=\"MathMLEq1\" style=\"vertical-align: middle;\" src=\"/SOCH/img.PNG\" alt=\"\"/></html> <html><img id=\"MathMLEq1\" style=\"vertical-align: middle;\" src=\"/SOCH/img.PNG\" alt=\"\"/></html> <html><img id=\"MathMLEq1\" style=\"vertical-align: middle;\" src=\"/SOCH/img.PNG\" alt=\"\"/></html>";
StringBuffer q= new StringBuffer(inputString);
String add = "file:///mnt/sdcard";
//Get all indexed of the occurrence of /SOCH string
for (int index = inputString.indexOf("/SOCH");
     index >= 0;
     index = inputString.indexOf("/SOCH", index + 1)){

    arrayList.add(index); //add the indexes to arrayList
}
int prev = 0;
for (int i = 0; i < arrayList.size(); i++){ // for all indexes
    q = q.insert(prev+ arrayList.get(i),add); //Insert the add string at position (index + (number of times 'add' string appears * length of 'add' string)  
    prev = (i+1)*add.length(); // calculate the next position where to insert the string

}
String result = q.toString(); //Gives the final output as desired.