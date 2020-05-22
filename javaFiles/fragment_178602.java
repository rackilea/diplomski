for (int i = 0; i < x.size(); i++) {
  if (x.get(i).id.equals(k.id)) { //change here
    Object obj = x.remove(i);
    break;
  }
}