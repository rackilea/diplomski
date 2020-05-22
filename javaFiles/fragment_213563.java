db.cars.find({
    $expr: {
        $gte: [
            "$keepAlive", 
            { 
                $subtract: [
                    new Date(), 
                    {$toDate: "$dateAdded"}
                ]
            }
        ]
    }
})