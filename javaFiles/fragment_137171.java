public List<ArrayList<Object>> concat (List<ArrayList<Object>> list1, List<ArrayList<Object>> list2) {
   if(list1.size() > list2.size()) {
      List<ArrayList<Object>> listBig = new ArrayList(list1); // or just list1 if we can change list1
      List<ArrayList<Object>> listSmall = list2;
   } else {
      List<ArrayList<Object>> listBig = new ArrayList(list2); // or just list1 if we can change list1
      List<ArrayList<Object>> listSmall = list1;
   }

   for(int i = 0; i < listSmall.size(); i++) {
      listBig[i].addAll(listSmall[i]); 
   }
   return listBig;
}