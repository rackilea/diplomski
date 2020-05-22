// ... your program

StringBuilder hexString = new StringBuilder();
StringBuilder eightBits = new StringBuilder();
for(int i = 0; i < binary.size(); i += 8) {                 
    for(int j = i; j < (i + 8) && j < binary.size(); j++) { // read next 8 bits or whatever bits are remaining
        eightBits.append(binary.get(j)); // build 8 bit value
    }
    int decimal = Integer.parseInt(eightBits.toString(), 2); // get decimal value
    hexString.append(Integer.toHexString(decimal) + " "); // add hex value to the hex string and a space for readability 
    eightBits.setLength(0); // reset so we can append the new 8 bits
}
System.out.println(hexString.toString()); // prints "5 43 9d" for the value you gave