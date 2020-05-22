{
  "$and":[
    {"place":{"$exists":true}},
    {"$or":[
      {"$where":'this.pubDate > this.relDate'},
      {"pubDate":{"$exists":false}},
      {"relDate":{"$exists":false}}
    ]}
  ]
}