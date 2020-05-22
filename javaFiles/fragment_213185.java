"query": {
  "script": {
    "script": {
      "inline": "float sum = 0.0f; for (float v: params['_source'].values()) { sum += v; } return (sum > 50);",
      "lang": "painless"
    }
  }
}