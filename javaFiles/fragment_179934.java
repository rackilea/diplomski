curl -X POST -H 'Content-type:application/json' --data-binary '{
  "add-field":{
     "name":"category",
     "type":"strings",
     "stored":true }
}' http://localhost:8983/solr/collection/schema