BitSet b1 = new BitSet();
// Fill it with booleans:
for ( int i = 0 ; i < myBooleans.length ; i++ )
    b1.set(i, myBooleans[i]);
// Or fill it with bytes:
BitSet b1 = BitSet.valueOf(myBytes);
// Or fill it with 0/1 from a string:
for ( int i = 0 ; i < myString.length() ; i++ )
    b1.set(i, myString.charAt(i) == "1");

BitSet b2 = new BitSet();
// Same as above

BitSet result = new BitSet();
result.or(b1); // Copies b1
result.or(b2); // Makes the OR
result.flip(0,result.size()); // Negates - the result is a NOR
result.clear(Math.min(b1.size(), b2.size()), result.size()); // Only retain the common size