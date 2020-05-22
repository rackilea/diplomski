for(int i =0; i < lines.size(); i++) {
  if(list.get(i).equals("")) {
    list.remove(i);
  }
}
return list;