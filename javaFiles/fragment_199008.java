curl -X POST \
  https://jsonplaceholder.typicode.com/posts \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 907bbf75-73f5-703f-c8b6-3e1cd674ebf7' \
  -d '{
        "userId": 100,
        "id": 100,
        "title": "main title",
        "body": "main body"
    }'