String huffmanCode = "0100"; // lets say its huffman coding output for c

BitSet huffmanCodeBit = new BitSet(huffmanCode.length());

for (int i = 0; i < huffmanCode.length(); i++) {
    if(huffmanCode.charAt(i) == '1')
        huffmanCodeBit.set(i);
}
String path = Resources.getResource("myfile.out").getPath();
ObjectOutputStream outputStream = null;
try {
    outputStream = new ObjectOutputStream(new FileOutputStream(path));
    outputStream.writeObject(huffmanCodeBit);
} catch (IOException e) {
    e.printStackTrace();
}