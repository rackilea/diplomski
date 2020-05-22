for(String s : NAMA) {
  if(LENGKAP.size() == 4) {
    LENGKAP.add(s);
  } else {
    LENGKAP.set(4, s);
  }
  System.out.println(LENGKAP);
}