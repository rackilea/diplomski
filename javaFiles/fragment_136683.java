// for every Node in the template List
for(int i=0; i < templateList.getLength(); i++) {

  // cast each Node to a template Element
  Node theTemplate = templateList.item(i);
  Element templateElement = (Element) theTemplate;

  // get the xml filename as = template's name attribute + .xml
  String fileName = templateElement.getAttribute("name") + ".xml";

  // create a Path that points to the current directory
  Path filePath = Paths.get(fileName);

  // create the xml file at the specified Path
  Files.createFile(filePath);

  System.out.println("File "+ fileName + ".xml created");
}