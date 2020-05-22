{
  "size": 0,
  "aggregations": {
    "costs_agg": {
      "nested": {
        "path": "costs"
      },
      "aggregations": {
        "bool_agg": {
          "must": [
            {
              "range": {
                "costs.startDate": {
                  "gte": "2017-02-14T00:00:00+00:00"
                }
              }
            },
            {
              "range": {
                "costs.endDate": {
                  "lte": "2017-02-15T00:00:00+00:00"
                }
              }
            },
            {
              "wildcard": {
                "costs.region": "useast.*"
              }
            }
          ]
        },
        "aggregations": {
          "cost_sum_agg": {
            "sum": {
              "field": "costs.cost"
            }
          }
        }
      }
    }
  }
}