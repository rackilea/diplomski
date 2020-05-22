key = new SecretKeySpec(keyBytes, "GOST28147");

in = Cipher.getInstance("GOST28147/ECB/NoPadding", "BC");
out = Cipher.getInstance("GOST28147/ECB/NoPadding", "BC");
out.init(Cipher.ENCRYPT_MODE, key);
in.init(Cipher.DECRYPT_MODE, key);

//
// encryption pass
//
bOut = new ByteArrayOutputStream();

cOut = new CipherOutputStream(bOut, out);

for (int i = 0; i != input.length / 2; i++)
{
    cOut.write(input[i]);
}