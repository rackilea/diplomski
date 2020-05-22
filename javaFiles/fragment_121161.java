Element child = (Element) itr.next();
String name = "defaultName";
if(child.getQualifiedName().equals("name")){
  name = child.getText();
}
Key drugKey = KeyFactory.createKey("DrugTarget", name);