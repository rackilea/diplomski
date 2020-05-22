db.data.aggregate([{
    $group: {
        _id: {
            user: "$user",
            contact: "$contact"
        },
        count: {
            $sum: 1
        }
    }
}, {
    $group: {
        _id: "$_id.user",
        uniqueIds: {
            $push: {
                contact: "$_id.contact",
                count: "$count"
            }
        }
    }
}])