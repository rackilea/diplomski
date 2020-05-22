{ 

  "aggs": {
    "id1_count": {
      "terms": { "field": "empname" ,
      "order": {
          "Max_Marks": "desc"
        }
      },

      "aggs": {
        "Max_Marks": {
          "max": {
            "field": "marks"
          }
        },
        "min_marks":{
            "min":{
                "field":"marks"
            }
        }
      }