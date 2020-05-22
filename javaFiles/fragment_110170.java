db.collection.aggregate([
     {$addFields: {$subtract: [
           {$subtract: ["$value1","$value2"]}, //will serve as the first input for the outer $subtract
           "$value3"
     ]}
 ]);