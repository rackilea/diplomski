Collections.sort(list, new Comparator<String>() {
  public int compare(String e1, String e2) {
    int c = new Character(e1.chartAt(0)).compareTo( e2.charAt(0) );
    if( c!=0 )
       return c;
    return new Character(e2.chartAt(e2.length()-1)).compareTo( e1.charAt(e1.length()-1) )
  }
});