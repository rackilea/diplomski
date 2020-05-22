ByteArrayOutputStream fullPlaintextStream = new ByteArrayOutputStream();

byte[] dec1 = AESCipher.update(encrypted1);
fullPlaintextStream.write(dec1);

byte[] dec2 = AESCipher.update(encrypted2);
fullPlaintextStream.write(dec2);

byte[] dec3 = AESCipher.doFinal();
fullPlaintextStream.write(dec3);

r = new String(fullPlaintextStream.toByteArray());
assertEquals(expected, r);