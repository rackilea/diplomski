curl -X POST \
  -H "X-Parse-Application-Id: 000000000000000000000000000000000000000" \
  -H "X-Parse-REST-API-Key: 00000000000000000000000000000000000000000" \
  -H "Content-Type: application/json" \
  -d '{"movie":"The Matrix"}' \
  https://api.parse.com/1/functions/averageStars