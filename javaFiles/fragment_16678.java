@prefix :      <http://base/#> . @prefix tdb:  
<http://jena.hpl.hp.com/2008/tdb#> . @prefix rdf:  
<http://www.w3.org/1999/02/22-rdf-syntax-ns#> . @prefix ja:   
<http://jena.hpl.hp.com/2005/11/Assembler#> . @prefix rdfs: 
<http://www.w3.org/2000/01/rdf-schema#> . @prefix fuseki:
<http://jena.apache.org/fuseki#> .

:service_tdb_all  a                   fuseki:Service ;
        rdfs:label                    "LABEL_OF_YOUR_SERVICE" ;
        fuseki:dataset                :dataset ;
        fuseki:name                   "NAME_OF_YOUR_SERVICE" ;
        fuseki:serviceQuery           "query" , "sparql" ;
        fuseki:serviceReadGraphStore  "get" ;
        fuseki:serviceReadWriteGraphStore
                "data" ;
        fuseki:serviceUpdate          "update" ;
        fuseki:serviceUpload          "upload" .

:dataset a ja:RDFDataset ;
  ja:defaultGraph <#modeInf>; .

<#modeInf> a ja:InfModel;
  ja:baseModel <#tdbGraph>;
  ja:reasoner   [
    ja:reasonerClass    "openllet.jena.PelletReasonerFactory" ]
  .  

<#tdbGraph> rdf:type tdb:GraphTDB ;
  tdb:dataset :tdb_dataset_readwrite  .

:tdb_dataset_readwrite  a            
  tdb:DatasetTDB ;  tdb:location 
  "PATH_TO_YOUR_TDB"
  .