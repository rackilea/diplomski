int arrlen = dis.readInt();
byte[] b = new byte[arrlen];
int i = 0;
for(i = 0; i < arrlen; i++) {
    b[i] = dis.readByte();
    i++;
}