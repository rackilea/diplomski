GET students/_search
{
  "query": {
  "bool": {
     "should": [
        {
           "bool": {
              "must": [
                 {
                    "term": {
                       "name": {
                          "value": "XXX"
                       }
                    }
                 },
                 {
                    "term": {
                       "rollno": {
                          "value": "1"
                       }
                    }
                 }
              ]
           }
        },
        {
           "bool": {
              "must": [
                 {
                    "term": {
                       "name": {
                          "value": "YYY"
                       }
                    }
                 },
                 {
                    "term": {
                       "rollno": {
                          "value": "2"
                       }
                    }
                 }
              ]
           }
        }
     ]
  }}}