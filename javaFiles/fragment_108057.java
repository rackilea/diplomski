public boolean isDuplicate(List<Map<String, String>> list, Map<String, String> map){
  //Count the occurences of the searched element.
  int cpt = 0;

  /*
   * Here, another iterator is implicitly created.
   * It is not the same as in the main loop. 
   * That's why I avoid the ConcurrentModificationException.
   */
  for(Map<String, String> m : list) {
    if(m.get("section").equals(map.get("section")) && m.get("index").equals(map.get("index"))) {
      cpt++;
    }
  }
  //If the element is found twice, then it is a duplicate.
  return cpt == 2;
}