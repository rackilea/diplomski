BitSet bits = new BitSet();
//set the bit fields...

//convert bitset to integer
int bitInteger = 0;
for(int i = 0 ; i < bits.length(); i++) {
    if(bits.get(i)) {
        bitInteger |= (1 << i);   //logical OR each bit into the integer and shift left
    }
}