SELECT *
 WHERE { 
         # data from Primary dataset
         ?uri a skos:Concept ;
              skos:prefLabel ?prefLabel ;
              skos:altLabel ?altLabel .

         # data from Secondary dataset  
         SERVICE <http://localhost:8080/openrdf-sesame/repositories/Secondary>  {
             ?uri :customField ?customFieldValue .
         }
}