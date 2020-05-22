db.collection.aggregate([
    { "$match": { "_id": ObjectId("545b9fa0dd5318a4285f7ce7") } },
    { "$unwind": "$messages" },
    { "$group": {
        "_id": "$_id",
        "sent": {
            "$sum": {
                "$cond": [
                    { "$eq": [ "$mesages.status", "sent" ] },
                    1,
                    0
                ]
            }
        },
        "pending": {
            "$sum": {
                "$cond": [
                    { "$eq": [ "$messages.status", "pending" ] },
                    1,
                    0
                ]
            }
        },
        "done": {
            "$sum": {
                "$cond": [
                    { "$eq": [ "$messages.status", "done" ] },
                    1,
                    0
                ]
            }
        }
    }}
])