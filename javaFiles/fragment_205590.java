// the second parameter specifies whether the file should be appended
try(OutputStream fos = new FileOutputStream(new File("transactions.json"), true)) {

    // pass the FileOutputStream to the generator instead
    JsonGenerator generator = factory.createGenerator(fos , JsonEncoding.UTF8);
}