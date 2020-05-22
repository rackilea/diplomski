@Test
public void testNullsUsingProcessors() throws IOException{
    String csv = ",null,NULL\n";
    CellProcessor[] processors = {new CustomOptional(), 
                                  new CustomOptional(), 
                                  new CustomOptional()};
    try (ICsvListReader reader = new CsvListReader(new StringReader(csv), 
        CsvPreference.STANDARD_PREFERENCE)){
        List<Object> values = reader.read(processors);
        for (Object v : values){
            System.out.println(v == null);
        }
    }
}