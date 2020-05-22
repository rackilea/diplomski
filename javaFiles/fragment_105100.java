byte[] byteArray = new byte[longCount * 8];
FileInputStream fis = new FileInputStream("lotsoflongs");
fis.read(byteArray);
fis.close();
for (int i = 0; i < longCount; i += 8)
    longArray[i >> 3] = ((long) byteArray[0+i]        << 56) +
                        ((long)(byteArray[1+i] & 255) << 48) +
                        ((long)(byteArray[2+i] & 255) << 40) +
                        ((long)(byteArray[3+i] & 255) << 32) +
                        ((long)(byteArray[4+i] & 255) << 24) +
                              ((byteArray[5+i] & 255) << 16) +
                              ((byteArray[6+i] & 255) <<  8) +
                              ((byteArray[7+i] & 255) <<  0);