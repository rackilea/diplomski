[/c]$ curl -X POST \
>   https://jsonplaceholder.typicode.com/posts \
>   -H 'cache-control: no-cache' \
>   -H 'postman-token: 907bbf75-73f5-703f-c8b6-3e1cd674ebf7' \
>   -d '{
>         "userId": 100,
>         "id": 100,
>         "title": "main title",
>         "body": "main body"
>     }'

  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   258  100   150  100   108    147    106  0:00:01  0:00:01 --:--:--   192{
  "{\n        \"userId\": 100,\n        \"id\": 100,\n        \"title\": \"main title\",\n        \"body\": \"main body\"\n    }": "",
  "id": 101
}