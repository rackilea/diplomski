long longHash = 0;
try {
     HX h = new HX(seed);
     longHash = h.getHash();
} catch(Exception e) {
     e.printStackTrace();
}

try {
  int hash = Integer.parseInt(longHash.substring(0,9));
} catch(Exception e) {
  int hash = Integer.parseInt(longHash.substring(0,8));
}