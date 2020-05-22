BoxIterator boxList = new BoxIterator(xml_stream);
for (Box box : boxList) {
  for (Drawer drawer : box) {
    drawer.getId();
  }
}