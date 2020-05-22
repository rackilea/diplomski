String[] datas = new String[3];
 Random rand = new Random();
 rand.setSeed(System.currentTimeMillis());

 int i = rand.nextInt(datas.length);
 String val = datas[i];
 datas[i] = null;
 return val;