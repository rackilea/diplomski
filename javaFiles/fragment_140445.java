@Test
public final void testManual() throws IOException {
    ICsvListReader reader = new CsvListReader(new StringReader(CSV), 
        CsvPreference.STANDARD_PREFERENCE);
    reader.getHeader(true); // skip header

    List<String> firstNames = new ArrayList<String>();

    List<String> line;
    while((line = reader.read()) != null){
        firstNames.add(line.get(0));
    }

    // prints: [John, Bob]
    System.out.println(firstNames);
}