db.expiring.aggregate([
  { "$project": {
    "contractDate": 1,
    "term": 1,
    "expires": {
      "year": {
        "$cond": [
          { "$gt": [ 
            { "$add": [{ "$month": "$contractDate" }, "$term" ] },
            12
          ]},
          { "$add": [{ "$year": "$contractDate" }, 1 ] },
          { "$year": "$contractDate" }
        ]
      },
      "month": {
        "$cond": [
          { "$gt": [
            { "$add": [{ "$month": "$contractDate" }, "$term" ] },
            12
          ]},
          { "$subtract": [
            { "$add": [{ "$month": "$contractDate" }, "$term" ] },
            12
          ]},
          { "$add": [{ "$month": "$contractDate" }, "$term" ] }
        ]
      },
      "day": { "$dayOfMonth": "$contractDate" }
    }
  }},
  { "$group": {
    "_id": null,
    "count": {
      "$sum": {
        "$cond": [
          { "$or": [
             { "$gt": [ "$expires.year", thisYear ] },
             { "$and": [
               { "$eq": [ "$expires.year", thisYear ] },
               { "$gt": [ "$expires.month", thisMonth ] },
             ]},
             { "$and": [
               { "$eq": [ "$expires.year", thisYear ] },
               { "$eq": [ "$expires.month", thisMonth ] },
               { "$gt": [ "$expires.day", thisDay ] }     
             ]}
          ]},
          1,
          0
        ]
      }
    }
  }}
])