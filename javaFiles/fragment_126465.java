db.person.aggregate([
    {$group: {
        _id: null,
        maxDate: {$max : { 
            $cond: [ 
                {$gt : ["$birth_date_time","$children.birth_date_time"]}, 
                "$birth_date_time", 
                "$children.birth_date_time"
            ]}}
    }}  
])