> db.cars.aggregate([
    {
        $project: {
            vin: 1, 
            keepAlive:1, 
            dateAdded:1, 
            notExpired: {
                $gte:[
                    "$keepAlive",
                    { 
                        $subtract:[
                            new Date(),
                            { $toDate:"$dateAdded" }
                        ]
                    }
                ]
            }
        }
    },
    {
        $match: { notExpired: true }
    },
    {
        $project: { notExpired: 0 }
    }
])