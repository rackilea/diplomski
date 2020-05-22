@Test
public void testNullsWithDefaultBehaviour() throws IOException{
    String csv = ",null,NULL\n";
    try (ICsvListReader reader = new CsvListReader(new StringReader(csv), 
        CsvPreference.STANDARD_PREFERENCE)){
        List<String> values = reader.read();
        for (String v : values){
            System.out.println(v == null);
        }
    }
}