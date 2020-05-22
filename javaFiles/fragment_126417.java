>db.collection.aggregate(
    [
        {$match:{days:{"$exists":1}}},
        {$project:{
          numberOfDays: {$size:"$days"},
          _id:1}
        }
    ]
)