void place(int num, byte[] store, int where){
    for(int i = 0; i < 4; ++i){
        store[where+i] = (byte)(num & 0xFF);
        num >>= 8;
    }
}