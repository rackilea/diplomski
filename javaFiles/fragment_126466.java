db.person.aggregate([{
    $project: {
        mDate: {
            $cond: [
                {$gt : ["$birth_date_time","$children.birth_date_time"]}, 
                "$birth_date_time", 
                "$children.birth_date_time"
            ]
        }
    }},
    {$group: {
        _id: null,
        maxDate: {$max : "$mDate"}
    }},    

])