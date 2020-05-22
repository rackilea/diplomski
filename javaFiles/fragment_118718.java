PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX : <http://www.semanticweb.org/test-ontology#> 
ASK { 
?cls a owl:Class
FILTER NOT EXISTS {
 ?s a ?cls .
 ?s :value_of_individual "MyLiteral"^^xsd:string
}
}