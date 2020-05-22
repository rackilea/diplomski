List<Integer> checkedList = new ArrayList<Integer>();
 for (Product p : boxAdapter.getBox()) {

   if (p.aBoolean)
       checkedList.add(p.id);

 }