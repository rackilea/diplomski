// create a StringBuffer to hold the ciphertext. Maximum you need double its size if all the byte is 0x0 and 0x9 
StringBuffer stringbuffer = new StringBuffer(cipherbyte.length * 2);


    for (int i = 0; i < cipherbyte.length; i++) { // get each byte
        if ((cipherbyte[i] & 0xff) < 0x10 ) {  // if byte is between 0x0 and 0x9, padding a 0
            stringbuffer.append("0");
        }
        // get current byte as long type and convert into a 16 radix string.
        // this combine the code above if byte is between 0x0 and 0x9
        stringbuffer.append(Long.toString(cipherbyte[i] & 0xff, 16));
    }


    String ciphertext = stringbuffer.toString();
    return ciphertext;