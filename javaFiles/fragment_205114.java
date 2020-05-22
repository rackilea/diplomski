private Document downloadSpFile(CopySoap p, String url) throws IOException {
    // Define the variables that will store the output from the web service
    // call
    System.out.println("Holders...");
    Holder<Long> l = new Holder<Long>();
    Holder<FieldInformationCollection> myFieldInfoArray = new Holder<FieldInformationCollection>();
    Holder<byte[]> myByteArray = new Holder<byte[]>();

    System.out.println("Call Web Service...");
    // Call the web service
    p.getItem(url, l, myFieldInfoArray, myByteArray);

    System.out.println("TEST - Write to Disk...");
    // Write to file system - TESTING
    //Files.write(Paths.get("target-file.pdf"), myByteArray.value);

    System.out.println("Convert to Adobe Document");
    try {
        return new Document(myByteArray.value);
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
}