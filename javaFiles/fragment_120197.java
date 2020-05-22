public static final String queryString = "prefix rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+ 
        "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"+
        "prefix crm:  <http://www.cidoc-crm.org/cidoc-crm/>\n"+
        "\n"+
        "SELECT * WHERE{\n"+
        "   [ crm:E21_Person/rdfs:label ?creator\n"+
        "   ; crm:P108i_was_produced_by [ crm:P126_employed [ rdfs:label ?material ]\n"+
        "                               ; crm:P4_has_time-span [ crm:P82_at_some_time_within ?timespan ]\n"+
        "                               ]\n"+
        "   ; crm:P3_has_note [ a crm:P102_has_title\n"+
        "                     ; rdfs:label ?title\n"+
        "                     ]\n"+
        "   ]\n"+
        "  FILTER( ?creator = \"Brett WHITELEY\" ).\n"+
        "}";
public static final Query query = QueryFactory.create(queryString);

@Test
public void test() throws Exception {

    final Model model = ModelFactory.createDefaultModel();
    try( final InputStream in = this.getClass().getResourceAsStream("/so.rdf") ) {
        model.read(in, null, "RDF/XML");
    }
    model.write(System.out, "TTL");
    System.out.println("=================================================================");
    System.out.println(queryString);
    System.out.println("=================================================================");
    try( final QueryExecution exec = QueryExecutionFactory.create(query, model) ) {
        ResultSetFormatter.out(System.out, exec.execSelect(), query);
    }

}