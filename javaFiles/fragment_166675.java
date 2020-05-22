curl -X POST \
  http://localhost:8080/register/reg \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
  "id": 300,
  "name": "kukri",
  "age": 26,
  "registrationNumber": "54326",
  "payment_detailsList": {
    "pay": 50000,
    "date": "23061994",
    "phcounter": "SKB"
  }
}'