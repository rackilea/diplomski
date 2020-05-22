XML xml;
int start = 1000;
int end = 1901;
int[] multiZips = new int[end- start]; 

for (int i = start; i < end; i++) {

  multiZips[i-start] = i;
}

//load once
xml = loadXML("sample.xml");
//get a reference to <childtwo>
XML firstChild = xml.getChild("childTwo");

for (int j : multiZips ) {
  String zip = str(j);
  //create a new node (in this case we'll call it zip, but it can be something else)  
  XML newNode = new XML("zip");
  //set the value as it's content
  newNode.setContent(zip);
  //append the new node to the <childTwo> node
  firstChild.addChild(newNode);
}
//save once
saveXML(xml,"sample.xml");