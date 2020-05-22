Iterable<MyObject> myObjects = myRepo.findAll(idList);
List<MyObject> myObjectsList = IteratorUtils.toList(myObjects.iterator());
Page<MyObject> myObjectsPage = new PageImpl<MyObject>(
                                     myObjectsList,
                                     new PageRequest(page, size), 
                                     myObjectsList.size());