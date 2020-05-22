{
    "_id":"_design/contacts",
    "fulltext": {
        "by_phone": {
            "index":"function(doc) { var ret=new Document(); ret.add(doc.phone_num); return ret }"
        }
    }
}