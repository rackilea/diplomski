// Concatenate IV and ciphertext
byte[] iv = ...
byte[] ciphertext = ...
byte[] ivAndCiphertext = new byte[iv.length + ciphertext.length];
System.arraycopy(iv, 0, ivAndCiphertext, 0, iv.length);
System.arraycopy(ciphertext, 0, ivAndCiphertext, iv.length, ciphertext.length);
// If required: Base64-encoding