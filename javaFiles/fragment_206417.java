"function_score": {
          "query": { "match_all": {} },
          "boost": "5", 
          "functions": [
              {
                  "filter": { "match": { "vector": "111" } }, 
                  "weight": 1
              },
              {
                  "filter": { "match": { "vector": "222" } },
                  "weight": 1
              }
              ...
          ],
          "max_boost": 1,
          "score_mode": "max",
          "boost_mode": "replace",
          "min_score" : 0
        }