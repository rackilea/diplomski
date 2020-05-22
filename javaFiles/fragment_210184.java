ABIdClass abId = new ABIdClass();
abId.setA(a);
abId.setB(b);
ABClass ab = new ABClass();
ab.setId(abId);
ab.setCode("1.2.3"); 
a.getABClass().add(ab);