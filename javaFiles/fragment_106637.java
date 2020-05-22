{
  "size": 0, 
  "aggs": {
    "per_customer": {
      "terms": {
        "field": "customerId",
        "size": 10
      },
      "aggs": {
        "total_price": {
          "sum" : { "field" : "price" }
        },
        "total_revenue": {
          "sum" : { "field" : "revenue" }
        }
      }
    }
  }
}