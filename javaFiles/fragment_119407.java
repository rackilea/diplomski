db.collection.aggregate([
  // matches documents with a senses sub document having the given lang and source values
  {$match: {'senses.lang': 'EN', 'senses.source': 'EN_DICTIONARY'}},

  // projects on the senses sub document and filters the output to only return sub 
  // documents having the given lang and source values
  {$project: {
      senses: {
        $filter: {
            input: "$senses",
            as: "sense",
            cond: { $eq: [ "$$sense.lang", 'EN' ], $eq: [ "$$sense.source", 'EN_DICTIONARY' ] }
          }
        }
      }
  }
])