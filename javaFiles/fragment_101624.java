{
    "$nor" : [ 
        { 
            "onlinedate" : { "$gte" : date }, 
            "offlinedate" : { "$lte" : date }
        }
    ]
}