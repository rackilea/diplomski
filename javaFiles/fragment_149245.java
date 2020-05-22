public List<Person> parse(final InputStream is) throws IOException {
    CharSet cs = ... // Use the right charset for your file
    Stream<String> lines = new BufferedReader(new InputStreamReader(is, cs)).lines();
    return  lines
            .map(Person::new)   
            .collect(toList());
}