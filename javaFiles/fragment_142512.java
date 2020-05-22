db.collection.aggregate([
    { "$group": {
        "_id": {
            "ApplicationId": "$TracInfo.ApplicationId",
            "EventName": "$Name",
        },
        "oScreenViewCount": { 
            "$addToSet": {
                "ScreenName": "$ScreenName",
                "SessionId": "$TracInfo.SessionId",
            }
        },
        "oDeviceCount": { "$addToSet": "$TracInfo.DeviceId" },
        "oUserCount": { "$addToSet": "$TracInfo.UserId" },
        "oEventcount": { "$sum": 1 }
    }},
    { "$project": {
        "_id": 0,
        "ApplicationId": "$_id.ApplicationId",
        "EventName": "$_id.EventName",
        "EventCount": "$oEventCount",
        "ScreenViewCount": { "$size": "$oScreenViewCount" },
        "DeviceCount": { "$size": "$oDeviceCount" },
        "UserCount": { "$size": "$oUserCount" }
    }}
])