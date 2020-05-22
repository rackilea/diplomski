db.test.aggregate( [
{ 
  $project: { 
      dt: { 
         $dateFromString: { dateString: "$dt", format: "%d/%m/%Y" } 
      }
  }
},
{ $sort: { dt : -1 } },
{ $skip: 2 },
{ $limit: 1 }
] )