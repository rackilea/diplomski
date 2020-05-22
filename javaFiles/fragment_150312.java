$ fbapi '/v2.8/me'
{
  "name": "Yuri Schimke",
  "id": "zzzzzz"
}

$ fbapi '/v2.8/me?fields=name,email,birthday,picture&debug=all'
{
  "name": "Yuri Schimke",
  "email": "www@xxxx.zz",
  "birthday": "xx/xx/xxxx",
  "picture": {
    "data": {
      "is_silhouette": false,
      "url": "https://scontent.xx.fbcdn.net/v/t1.0-1/p50x50/xxxx.jpg"
    }
  },
  "id": "xxxx",
  "__debug__": {}
}