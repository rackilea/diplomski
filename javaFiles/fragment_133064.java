db.collection.aggregate([
    {
        "$project": {
            "_id": 0, "customer_count": { "$size": "$customers" }
         }
    }
]);