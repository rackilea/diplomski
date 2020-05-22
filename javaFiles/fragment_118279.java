{
   "_id": "_design/mydesign",
   "_rev": "1-088646f81629ce559b6d9772c6116113",
   "views": {
       "by_timestamp": {
           "map": "function(doc) { emit(doc.timestamp, doc); }"
       }
   }
}