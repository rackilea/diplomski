BitSet bits = new BitSet();
// the below is all redundant
// none
bits.set(0, false);
// monday
bits.set(1, false);
// tuesday
bits.set(2, false);
// wed
bits.set(3, false);
// thu
bits.set(4, false);
// fri
bits.set(5, false);
// sat
bits.set(6, false);
// sun
bits.set(7, false);
// EOF redundant part
// mon + tue (last index exclusive)
bits.set(1, 3);
// comparison, tue + wed
BitSet compare = new BitSet();
// tue + wed
compare.set(2, 4);
System.out.println(bits.equals(compare)); // false
System.out.println(bits.intersects(compare)); // true