PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> 
PREFIX test: <http://www.semanticweb.org/test-ontology#> 
ASK {
 VALUES ?cls {test:ClassA test:ClassB test:ClassC} 
 ?s a ?cls .
 ?s test:value_of_individual "valueC3"^^xsd:string 
}