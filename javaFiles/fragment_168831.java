db.users.aggregate(
   [
      { "$sample": { "size": 100 } },
      { "$group": { "_id": null, "ageStdDev": { "$stdDevSamp": "$age" } } }
   ]
)