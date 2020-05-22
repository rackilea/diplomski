PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX my: <http://127.0.0.1/ontology/ApothecaryOntology.owl#>

SELECT  ?result WHERE {
  ?result rdf:ID my:HealthInsuranceNumber .
}