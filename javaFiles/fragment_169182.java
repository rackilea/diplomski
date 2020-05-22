// After you already have generated the digest
byte[] mdbytes = md.digest();
byte[] key = new byte[mdbytes.length / 2];

for(int I = 0; I < key.length; I++){
    // Choice 1 for using only 128 bits of the 256 generated
    key[I] = mdbytes[I];

    // Choice 2 for using ALL of the 256 bits generated
    key[I] = mdbytes[I] ^ mdbytes[I + key.length];
}

// Now use key as the input key for AES