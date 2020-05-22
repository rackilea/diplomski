[
  {
    "$addFields": {
      "prop2": {
        "$arrayToObject": {
          "$map": {
            "input": {
              "$objectToArray": "$prop2"
            },
            "as": "prop_2",
            "in": {
              "k": "$$prop_2.k",
              "v": {
                "$cond": [
                  {
                    "$eq": [
                      "$$prop_2.k",
                      "prop21"
                    ]
                  },
                  {
                    "$arrayToObject": {
                      "$map": {
                        "input": {
                          "$objectToArray": "$$prop_2.v"
                        },
                        "as": "prop_21",
                        "in": {
                          "k": {
                            "$arrayElemAt": [
                              {
                                "$split": [
                                  "$$prop_21.k",
                                  "_"
                                ]
                              },
                              0
                            ]
                          },
                          "v": "$$prop_21.v"
                        }
                      }
                    }
                  },
                  "$$prop_2.v"
                ]
              }
            }
          }
        }
      }
    }
  }
]