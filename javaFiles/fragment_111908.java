[
  {
    "$addFields": {
      "prop2": {
        "$map": {
          "input": "$prop2",
          "as": "prop_2",
          "in": {
            "prop": "$$prop_2.prop",
            "value": {
              "$cond": [
                {
                  "$eq": [
                    "$$prop_2.prop",
                    "prop21"
                  ]
                },
                {
                  "$map": {
                    "input": "$$prop_2.value",
                    "as": "prop_21",
                    "in": {
                      "prop": {
                        "$arrayElemAt": [
                          {
                            "$split": [
                              "$$prop_21.prop",
                              "_"
                            ]
                          },
                          0
                        ]
                      },
                      "value": "$$prop_21.value"
                    }
                  }
                },
                "$$prop_2.value"
              ]
            }
          }
        }
      }
    }
  }
]