XML xml;
int start = 1000;
int end = 1901;
int[] multiZips = new int[end- start]; 

for (int i = start; i < end; i++) {

  multiZips[i-start] = i;
}

//load the XML once
xml = loadXML("sample.xml");
//get a reference to the child you want to append to
XML firstChild = xml.getChild("childTwo");
//create a string to concatenate to
String zips = "";

for (int j : multiZips ) {
  String zip = str(j);

  //append to string  
  zips += (zip + ", ");
}
//add the concatenated string
firstChild.setContent(zips);
//save once
saveXML(xml, "sample.xml");