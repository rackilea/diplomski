PrivateKey key = // ...

byte[] enc_key = key.getEncoded();

// Byte array to string

StringBuilder key_builder = new StringBuilder();

for(byte b : enc_key){
    key_builder.append(String.format("%02x", b));
}

String serialized_key = key_builder.toString();