// txid A byte-swapped
    byte[] A = swapEndianness(
            hexStringToByteArray("b1fea52486ce0c62bb442b530a3f0132b826c74e473d1f2c220bfa78111c5082")
        );
    // txid B byte-swapped
    byte[] B = swapEndianness(
            hexStringToByteArray("f4184fc596403b9d638783cf57adfe4c75c605f6356fbc91338530e9831e9e16")
        );
    // txid A + B concatenated
    byte[] AB = Arrays.copyOf(A, A.length + B.length);
    System.arraycopy(B, 0, AB, A.length, B.length);

    // print result byte-swapped back to big-endian
    String result = getHex(swapEndianness(SHA256(SHA256(AB))));
    System.out.println(result);         
    }
    byte[] swapEndianness(byte[] hash) {
        for (int i = 0; i < hash.length/2; i++) {
            byte t = hash[hash.length-i-1];
            hash[hash.length-i-1] = hash[i]; 
            hash[i] = t; 
        }
        return hash;
    }