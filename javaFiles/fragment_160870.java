int[] iToken = initArray();
...
private int[] initArray() {
     String text = "200 300 250 150 400 100";
     String[] token = text.split("\\W");
     int[] itoken = new int[token.length];
     int i = 0;

     for (String str : token) {
         itoken[i++] = Integer.parseInt(str);
     }

     return itoken;
}