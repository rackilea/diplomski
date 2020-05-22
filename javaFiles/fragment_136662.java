Virtuoso 37000 Error SP030: SPARQL compiler, line 4: syntax error at 'London' before '}'

SPARQL query:
define sql:big-data-const 0 
#output-format:text/html
define sql:signal-void-variables 1 define input:default-graph-uri <http://dbpedia.org> select ?resource where {
  ?resource rdfs:label London
}