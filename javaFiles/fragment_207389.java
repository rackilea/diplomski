db.person.aggregate([
    {$unwind: "$address"},
    {$match: {"address.zip": 12345}},
    {$group: { _id: { "firstName":"$firstName", "lastName":"$lastName", _id:"$_id" }, address: { $push: "$address" } } },
    {$project: {_id:0, "firstName":"$_id.firstName", "lastName":"$_id.lastName", "address": "$address"}}
])