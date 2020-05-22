@prefix :      <http://127.0.0.1/ontology/ApothecaryOntology.owl#> .
@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix owl:   <http://www.w3.org/2002/07/owl#> .
@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .

:Person  a      owl:Class .

:Patient  a              owl:Class ;
        rdfs:subClassOf  :Person .

:HospitalPhysician  a    owl:Class ;
        rdfs:subClassOf  :Physician .

:TelephoneNumber  a       owl:Class ;
        rdfs:subClassOf   :Number ;
        owl:disjointWith  :HealthInsuranceNumber .

:Physician_hasID  a  owl:FunctionalProperty , owl:InverseFunctionalProperty , owl:ObjectProperty ;
        rdfs:domain  :Physician ;
        rdfs:range   :PhysicianID .

:Disease_hasSymptom  a  owl:FunctionalProperty , owl:ObjectProperty ;
        rdfs:domain  :Disease ;
        rdfs:range   :Symptom .