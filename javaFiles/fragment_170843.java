@prefix :      <http://www.examples.org/school#> .
@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .
@prefix owl:   <http://www.w3.org/2002/07/owl#> .
@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .
@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .

:Student  a              owl:Class ;
        rdfs:subClassOf  [ a                   owl:Class ;
                           owl:intersectionOf  ( :Person [ a                   owl:Restriction ;
                                                           owl:onProperty      :enrolledIn ;
                                                           owl:someValuesFrom  :Course
                                                         ] )
                         ] .

:Person  a      owl:Class .

:enrolledIn  a  owl:ObjectProperty .

:Course  a      owl:Class .

<http://www.examples.org/school>
        a       owl:Ontology .