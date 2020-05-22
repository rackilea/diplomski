// get the list for this element, or create one
  List list = map.get(attribute.getName());
  if(list == null) {
     list = new ArrayList();
     map.put(attribute.getName(), list);
  }
  // add the node we're working with to that list
  list.add(node);