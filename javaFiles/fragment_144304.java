byte[] input;
input = new byte [fis.available()];
while(fis.read() != -1) {
    test += new String (input);
}
testing = test;
fis.close();