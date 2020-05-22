curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "student": {
    "address": {
         .....
         "zipcode": "http://localhost:8082/zipcode/1",

     }
  },
  "id": 1,
  "zipcode": "http://localhost:8082/zipcode/1",
  "name": "John"
 }' 'http://localhost:8082/student'