void place(int num, byte[] store, int where){
    while(num != 0){
        store[where++] = (byte)(num & 0xFF);
        num >>>= 8;
    }
}