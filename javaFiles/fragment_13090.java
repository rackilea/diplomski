KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
try {
FileInputStream fis = ctx.getApplicationContext().openFileInput("bs.keystore");
ks.load(fis, ksPassword);
} catch(FileNotFoundException e) {
    ks.load(null, ksPassword);
}