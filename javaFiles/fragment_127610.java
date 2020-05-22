{
    "sort" : [
        { "price" : {"missing" : "_first"} },
    ],
    "query" : {
        "term" : { "user" : "kimchy" }
    }
}