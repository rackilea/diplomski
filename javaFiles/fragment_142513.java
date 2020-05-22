db.collection.aggregate([
    { "$group": {
        "_id": {
            "ApplicationId": "$TracInfo.ApplicationId",
            "EventName": "$Name",
        },
        "oScreenviewCount": { 
            "$addToSet": {
                "ScreenName": "$ScreenName",
                "SessionId": "$TracInfo.SessionId",
            }
        },
        "oDeviceCount": { "$addToSet": "$TracInfo.DeviceId" },
        "oUserCount": { "$addToSet": "$TracInfo.UserId" },
        "oEventcount": { "$sum": 1 }
    }},
    { "$unwind": "$oScreeenviewCount" },
    { "$group": {
        "_id": "$_id",
        "oScreenviewCount": { "$sum": 1 },
        "oDeviceCount": { "$first": "$oDeviceCount" },
        "oUserCount": { "$first": "$oUserCount" },
        "oEventcount": { "$first": "$oEventCount" }
    }},
    { "$unwind": "$oDeviceCount" },
    { "$group": {
        "_id": "$_id",
        "oScreenviewCount": { "$first": "$oScreenViewCount" },
        "oDeviceCount": { "$sum": "$oDeviceCount" },
        "oUserCount": { "$first": "$oUserCount" },
        "oEventcount": { "$first": "$oEventCount" }
    }},
    { "$unwind": "$oUserCount" },
    { "$group": {
        "_id": "$_id",
        "oScreenviewCount": { "$first": "$oScreenViewCount" },
        "oDeviceCount": { "$first": "$oDeviceCount" },
        "oUserCount": { "$sum": "$oUserCount" },
        "oEventcount": { "$first": "$oEventCount" }
    }},
    { "$project": {
        "_id": 0,
        "ApplicationId": "$_id.ApplicationId",
        "EventName": "$_id.EventName",
        "EventCount": "$oEventCount",
        "ScreenViewCount": "$oScreenViewCount",
        "DeviceCount": "$oDeviceCount",
        "UserCount": "$oUserCount"
    }}

])