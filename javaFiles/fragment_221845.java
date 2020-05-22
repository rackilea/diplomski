FileOutputStream fOut = null;
File file = new File (filename);

try {
    fOut = new FileOutputStream(file);
    fOut.write(byteWave);
    fOut.close();
}
catch (IOException e) {
    // Do something
}