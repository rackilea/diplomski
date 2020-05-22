int bytes = 2;
int nBits = bytes * 8;
int maxNumber = 1 << nBits; //this equals 2^nBits or in java: Math.pow(2,nbits)
ArrayList<String> binaries = new ArrayList<>();
for (int i = 0; i < maxNumber; i++) {
    String binary = Integer.toBinaryString(i);
    while (binary.length() != nBits) {
        binary = "0" + binary;
    }
    binaries.add(binary);
}
System.out.println(binaries);