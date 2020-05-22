select ?word (sum(?n) as ?nn) where {
  ?document rdf:type ?type .
  ?type rdf:value/rdf:value ?word ;
        :items ?n .
}
group by ?word