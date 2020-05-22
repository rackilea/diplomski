SELECT ?decAdmin ?country 
WHERE { 
       ?decAdmin a geo:DecAdm .
       OPTIONAL { ?decAdmin geo:belongsTo ?country .
                  ?country a geo:Country .
       }
} ORDER BY ?decAdmin