RDFList list = model.createList(new RDFNode[] {});
//string with names of rdf classes
String[] parts = list.split("-");

for(int i = 0; i<parts.length; i++){
    OntClass oclass = model.getOntClass("http://example.org/"+parts[i]);  
    list = list.with(oclass);
}