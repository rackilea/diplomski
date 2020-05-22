db.collection.find({ 
    "timestamp": { "$gte": startTime, "$lte": endTime },
    "hourOfDay": { "$gte": minHourOfDay, "$lte": maxHourOfDay },
    "$or": [
        { "dayOfWeek": 2 },
        { "dayOfWeek": 4 }
    ]
});