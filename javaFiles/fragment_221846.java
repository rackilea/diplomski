File file = new File (filename);

try (FileOutputStream fOut = new FileOutputStream(file)){
    fOut.write(byteWave);
}
catch (IOException e) {
    // Do something
}