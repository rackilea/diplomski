db.test.aggregate( [
{ 
  $project: { 
      dt: { 
         $dateFromString: { dateString: "$dt", format: "%d/%m/%Y" } 
      }
  }
},
] )