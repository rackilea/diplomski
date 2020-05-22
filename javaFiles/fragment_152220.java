final Unmarshaller u = jc.createUnmarshaller();
final File f = new File("D:\\item.xml");
final JAXBElement element = (JAXBElement) u.unmarshal(f);
final ItemList itemList = (ItemList) element.getValue();

// This will be helpful if the xml contains more elements
for (Item item : itemList.getItems()) {
   System.out.println(item.getCode());
   System.out.println(item.getName());
   System.out.println(item.getPrice());
}