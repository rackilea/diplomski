Map<String, String> avalue = new 
HashMap<String, String>();
avalue.put(a, a1);
avalue.put(b, b1);
avalue.put(c, c1);
avalue.put(d,d1)
jedis.hmset(key, avalue);