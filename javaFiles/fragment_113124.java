BitSet bitSet = new BitSet();
// set bit 100
bitSet.set(100);
// get bit 99
System.out.println("bit 99 is " + bitSet.get(99));
System.out.println("bit 100 is " + bitSet.get(100) + " after set");
bitSet.clear(100);
System.out.println("bit 100 is " + bitSet.get(100) + " after clear");