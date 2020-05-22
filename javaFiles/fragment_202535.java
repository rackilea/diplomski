db.collection.aggregate([

    // Group by the grouping key, but keep the valid values
    { "$group": {
        "_id": "$chainId",
        "docId": { "$first": "$_id" },
        "messageId": { "$first": "$messageId" },
        "createOn": { "$first": "$createdOn" }
    }},

    // Then sort
    { "$sort": { "createOn": -1 } }

])