Date x = new Date();
Date y = new Date();

Map<Date,Integer> hm = new IndentityHashMap<Date,Integer>();
hm.put(x,1);
hm.put(y,3);
assert hm.size() == 2: hm.size();