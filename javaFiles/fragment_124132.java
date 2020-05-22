void placeBigEndian(int num , byte[] store, int where){
    for(int i = 3; i >= 0; --i){
        store[where+i] = (byte)(num & 0xFF);
        num >>= 8;
    }
}

void placeBigEndian(int num, byte[] store, int where){
    in mask = 0xFF000000, shift = 24;
    while((mask & num) == 0){
        mask >>>= 8;
        shift -= 8;
    }
    while(shift > 0){
        store[where++] = (byte)((num & mask) >>> shift);
        mask >>>= 8;
        shift -= 8;
    }
}