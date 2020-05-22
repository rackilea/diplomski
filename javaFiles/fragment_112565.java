db.myitems.aggregate([
  {$project : 
    {tags: 1, item: 1, tag_count: {$size: "$tags" } }
  }, 
  {$match: 
    {$or: [{tags: "red"}, {tags: "blank"}, {tags: "black"}]} 
  }, 
  {$sort: {"tag_count": -1} } 
]);