public int getBookIndex(String find_tit) {
  for (int x = 0; x < nb; x++) { // not sure, but probably not <=
    if (titles[x].equals(find_tit)) { // not ==
       return x; // probably not x+1.
    }
  }
  return (-1);
}

public boolean updateTitle(String old_titl,
    String new_titl) {
  for (int x = 0; x < nb; x++) { // not sure, but probably not <=
    if (titles[x].equals(old_titl)) { // not ==
      titles[x] = new_titl;
      return true;
    }
  }
  return false;
}