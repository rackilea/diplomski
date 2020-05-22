Property geoProperty = /* like before */;
Property countryLargestCityProperty = 
    model. createProperty("http://dbpedia.org/property/",
                          "countryLargestCity");

SimpleSelector selector = new SimpleSelector(null, null, (RDFNode)null) {
    public boolean selects(Statement s)
        { return s.getPredicate().equals(geoProperty) || 
                 s.getPredicate().equals(countryLargestCityProperty) ;}
}
StmtIterator iter = model.listStatements(selector);
while(it.hasNext()) {
     /* same as in the previous example */
}