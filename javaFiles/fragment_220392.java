> db.createCollection("sa")
{ "ok" : 1 }
> db.sa.ensureIndex({"url":1},{unique:true})
> db.sa.insert({url:"http://www.example.com", crawled: true})
> db.sa.insert({url:"http://www.example.com", crawled: true})
E11000 duplicate key error index: test.sa.$url_1  dup key: { : "http://www.example.com" }
> db.sa.insert({url:"http://www.example2.com/", crawled: false})
> db.sa.insert({url:"http://www.example.com", crawled: false})
E11000 duplicate key error index: test.sa.$url_1  dup key: { : "http://www.example.com" }
>