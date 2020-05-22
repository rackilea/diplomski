"aggs": {
"2": {
  "date_histogram": {
    "field": "startDate",
    "interval": "month",
  },
  "aggs": {
    "1": {
      "sum": {
        "script": "((condition) ? 1 : 0)",
        "lang": "expression"
      }
    }
  }
}
}