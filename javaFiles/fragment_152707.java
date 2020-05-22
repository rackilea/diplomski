// send initial authentication request
byte[] result = idTag.transceive(Utils.wrapMessage((byte)0x0a, new byte[]{(byte)0x0}));

// get encrypted(randB) from the response
byte[] b0 = new byte[8];
for(int i = 0; i < 8; i++) {
    b0[i] = result[i];
}

// 16 bytes default key
byte[] key = new byte[] {(byte)0x0,(byte)0x0,(byte)0x0,(byte)0x0,
    (byte)0x0,(byte)0x0,(byte)0x0,(byte)0x0,
    (byte)0x0,(byte)0x0,(byte)0x0,(byte)0x0,
    (byte)0x0,(byte)0x0,(byte)0x0,(byte)0x0 };
// keys for TripleDes
byte[][] keys = new byte[3][];
keys[0] = key; keys[1] = key; keys[2] = key;

// decrypt encoded(randB)
byte[] r0 = DES.TripleDES_Decrypt(b0, keys);

// generate randA (integer 0-7 for trying, should randomize for real-life use) 
byte[] nr = new byte[8];
for(int i = 0; i < 8; i++) {
    nr[i] = Byte.parseByte(Integer.toString(i), 16);
}

// decrypt randA, should XOR with IV, but IV is all 0's, not necessary
byte[] b1 = DES.TripleDES_Decrypt(nr, keys);

// shift randB one byte left and get randB'
byte[] r1 =new byte[8];
for(int i = 0; i < 7; i++) {
    r1[i] = r0[i + 1];
}
r1[7]=r0[0];

// xor randB' with randA and decrypt
byte[] b2 = new byte[8];
for(int i = 0; i < 8; i++) {
    b2[i] = (byte) (b1[i] ^ r1[i]);
}
b2 = DES.TripleDES_Decrypt(b2, keys);

// concat (randA + randB')
byte[] b1b2 = new byte[16];

for (int i = 0; i < b1b2.length; i++) {
    if(i <= 7) {
        b1b2[i] = b1[i];
    } else {
        b1b2[i]=b2[i-8];
    }
}

result = idTag.transceive(Utils.wrapMessage((byte)0xaf, b1b2));