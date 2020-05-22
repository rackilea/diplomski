private String someMethod() throws IOException {
    // Java automatically closes the following Readers:
    try (BufferedReader br =
               new BufferedReader(new FileReader("/path"))) {
        return br.readLine();
    }
}