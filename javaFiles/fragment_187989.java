db.table.aggregate(
  [
    {
      $group: {
       _id : "$group_id",
       items : { "$push" : "$$ROOT" }
      }
    }
  ]
);