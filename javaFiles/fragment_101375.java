db.orders.aggregate([
  {
    "$lookup": {
      "from": "order_items",
      "as": "items",
      "localField": "_id",
      "foreignField": "order"
    }
  },
  {
    "$unwind": "$items"
  },
  {
    "$group": {
      "_id": "$_id",
      "totalOrderAmount": {
        "$sum": "$items.totalItemAmount"
      },
      "products": {
        "$push": "$items.product"
      }
    }
  },
  {
    "$project": {
      "_id": 0,
      "orderId": "$_id",
      "currency": 1,
      "totalOrderAmount": {
        "$toString": "$totalOrderAmount"
      },
      "products": 1
    }
  }
])