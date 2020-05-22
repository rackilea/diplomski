// create 2 hashes with 1M entries
for (int i = 0; i < 1000000; i++){
    String s = new BigInteger(80, random).toString(32);
    hash1.put(s, s);
    hash2.put(s, new BigInteger(80, random).intValue());
}

// create 1 hash with 1M entries
for (int i = 0; i < 1000000; i++){
    String s = new BigInteger(80, random).toString(32);
    NewClass n = new NewClass();
    n.i = new BigInteger(80, random).intValue();
    n.loc = s;
    hash3.put(s, n);
}

// 5M lookups
long start = new Date().getTime();
for (int i = 0; i < 5000000; i++){
    String s = "AAA";
    hash1.get(s);
    hash2.get(s);
}
System.out.println("Approach 1 (2 hashes): " + (new Date().getTime() - start));

// 5M lookups
long start2 = new Date().getTime();
for (int i = 0; i < 5000000; i++){
    String s = "BBB";
    hash3.get(s);
}
System.out.println("Approach 2 (1 hash): " + (new Date().getTime() - start2));