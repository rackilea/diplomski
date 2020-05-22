// default implementation, can be replaced in tests
FileWriter fileWriter = new FileWriter();

writeFile(key, bucket, tmp, status) {
    fileWriter.write(key, bucket, tmp, status);
};