TarArchiveInputStream tarInput = new TarArchiveInputStream(new GzipCompressorInputStream(new FileInputStream("c://temp//test.tar.gz")));
TarArchiveEntry currentEntry = tarInput.getNextTarEntry();
BufferedReader br = null;
StringBuilder sb = new StringBuilder();
while (currentEntry != null) {
    br = new BufferedReader(new InputStreamReader(tarInput)); // Read directly from tarInput
    System.out.println("For File = " + currentEntry.getName());
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println("line="+line);
    }
    currentEntry = tarInput.getNextTarEntry(); // You forgot to iterate to the next file
}