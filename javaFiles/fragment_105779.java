db.personaddress.aggregate([
    { "$unwind": "$address" },
    { "$unwind": "$address.location" },
    {
        "$lookup": {
            "from": "places", 
            "localField": "address.location.place._id", 
            "foreignField": "_id", 
            "as": "address.location.place", 
        }
    }
])