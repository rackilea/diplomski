db.user_log.aggregate(
  {$unwind: '$meta_data.access_times'},
  {$match: {"user_id" : "2", "meta_data.access_times" : { $gt : ISODate("2017-03-23T00:00:00.000Z"), $lt : ISODate("2017-03-24T00:00:00.000Z")}}},
  {$group: {_id: null, 'sum': { $sum: 1}}},
  {$group: {_id: '$_id', total_sum: {'$sum': '$sum'}}}
)