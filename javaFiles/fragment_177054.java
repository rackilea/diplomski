db.countries.aggregate([
  {
    "$unwind": "$cities"
  },
  {
    "$project": {
      "_id": 0,
      "cities": 1
    }
  },
  {
    "$replaceRoot": {
      "newRoot": "$cities"
    }
  }
])