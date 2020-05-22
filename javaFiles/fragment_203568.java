int sum = 0;
for(byte[] ba : arraysList) {
    sum = sum + ba.length;
}
byte[] newbuf = new byte[sum];
int curpos = 0;
for(byte[] ba : arraysList) {
    System.arraycopy(ba, 0, newbuf, curpos, ba.length);
    curpos = curpos + ba.length;
}