db.c.aggregate({$match: {query: "iPad"}}, {$unwind:"$rating"}, {$project: {_id:0, q:"$query",i:"$rating.inq"}}, {$group:{_id: "$q", max: {$max: "$i"}, min: {$min: "$i"}}}) :

{
    "result" : [
            {
                    "_id" : "iPad",
                    "max" : "403",
                    "min" : "123"
            }
    ],
    "ok" : 1
}