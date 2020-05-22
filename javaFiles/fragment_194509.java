SELECT  DISTINCT                                                             ?pl  
                                                                             ?pl_label 
                                                                             ?abstract 
                                                                             ?_thumbnail
        ( group_concat ( DISTINCT ?_influenced_label   ; separator="; " ) AS ?influenced )
        ( group_concat ( DISTINCT ?_influencedBy_label ; separator="; " ) AS ?influencedBy ) 
        ( group_concat ( DISTINCT ?_sameAs             ; separator=", " ) AS ?sameAs )     
        ( group_concat ( DISTINCT ?_paradigm_label     ; separator=", " ) AS ?paradigm )

WHERE
      { 
                      ?pl               rdf:type            dbo:ProgrammingLanguage ;
                                        rdfs:label          ?pl_label
                      FILTER ( LANG ( ?pl_label ) = 'en' ) .

          OPTIONAL  { ?pl               dbo:abstract        ?abstract . 
                      FILTER ( LANG ( ?abstract ) = 'en' ) . }

          OPTIONAL  { ?pl               dbo:influenced      ?_influenced . 
                      ?_influenced      rdfs:label          ?_influenced_label . 
                      FILTER ( LANG ( ?_influenced_label ) = 'en' ) . }

          OPTIONAL  { ?pl               dbo:influencedBy    ?_influencedBy . 
                      ?_influencedBy    rdfs:label          ?_influencedBy_label
                      FILTER ( LANG ( ?_influencedBy_label ) = 'en' ) . }

          OPTIONAL  { ?pl               owl:sameAs          ?_sameAs . } 

          OPTIONAL  { ?pl               dbp:paradigm        ?_paradigm .
                      ?_paradigm        rdfs:label          ?_paradigm_label 
                      FILTER ( LANG ( ?_paradigm_label ) = 'en' ) . }

          OPTIONAL { ?pl                dbo:thumbnail       ?_thumbnail . }

      } 

GROUP BY ?pl ?pl_label ?abstract ?_thumbnail