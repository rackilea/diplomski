{ 
    "onlinedate" : { "$lte" : date } , 
    "$or" : [ 
        { "offlinedate" : { "$gte" : date } } , 
        { "offlinedate" :  null }
    ]
}