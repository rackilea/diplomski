String[] mult(String[] base, int numBy) {
  String[] res = new String();
  for(int i = 0; i<numBy;i++) {

      String[] tmp = new String[res.length];
      System.arraycopy(tmp, 0, res, 0, res.length);

      res = new String[res.length + base.length];
      System.arraycopy(res, 0, tmp, 0, tmp.length);
      System.arraycopy(res,tmp.length,base,0,base.length);

  }
     return res;
}