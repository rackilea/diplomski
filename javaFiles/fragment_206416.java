"query" : {
    "bool" : {
        "should" : [
            //THIS IS THE PART THAT YOU PROGRAMATICALLY FILL USING THE VECTORS FROM THE PARENT YOU SPECIFIED
            {"match" : {"vector" : "111"}},
            {"match" : {"vector" : "222"}},
            {"match" : {"vector" : "333"}},
            ...
            {"match" : {"vector" : "444"}},
        ],
      "minimum_should_match": "50"
    }
}