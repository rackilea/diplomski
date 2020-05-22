db.foo.aggregate([
{$addFields: {X: {$reduce: {
                input: "$address",
                initialValue: 0,
                in: {$sum: [ "$$value", {"$cond":[ {"$ne": ["$$this",""]}, 1, 0]} \
]}
            }}
    }}
,{$match: {"X": {$gt:0} }}
                       ]);