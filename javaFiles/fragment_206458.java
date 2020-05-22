POST test/parks/_search
{
  "query": {
    "function_score": {
      "query": {
        "match": {
          "name": "Yellowstone National park"
        }
      },
      "functions": [
        {
          "gauss": {
            "location": {
              "origin": "41.4881832, -87.623177",
              "scale": "10km",
              "offset": "5km"
            }
          },
          "filter": {
            "geo_distance_range": {
              "from": "0km",
              "to": "30km",
              "location": {
                "lat": 41.881832,
                "lon": -87.623177
              },
              "include_upper": false
            }
          }
        },
        {
          "weight": ## Set appropriate weight,
          "filter": {
            "geo_distance_range": {
              "from": "30km",
              "location": {
                "lat": 41.881832,
                "lon": -87.623177
              },
              "include_lower": true
            }
          }
        }
      ]
    }
  }
}