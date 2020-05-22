[
{
    "$match": {
        "Category": {
            "$in": ["Mobile"]
        },
        "StartTime": {
            "$gte": {"$date": "2014-01-29T00:00:00.000Z"},
            "$lt": {"$date": "2014-09-29T00:00:00.000Z"}
        }
    }
},
{
    "$group": {
        "_id": {
            "Category": "$Category", 
            "Country":"$Country",
            "City":"$City",
            "day": {
                "day":{"$dayOfMonth": "$StartTime"},
                "month":{"$month":"$month"},
                "year":{"$year":"$year"},

                // add this part to group by for each day of each month of each year
                ampm : {
                    $cond : {
                        "if" : {
                            $lt : [ {
                                $hour : "$StartTime"
                            }, 12 ]
                        },
                        "then" : "AM", 
                        "else" : "PM"
                    }
                },
                segment : {
                    $let : {
                        "vars" : {
                            h : {
                                $hour : "$StartTime"
                            }
                        },
                        "in" : {
                            $cond : {
                                "if" : {
                                    $lt: [ "$$h", 6 ]
                                },
                                "then" : "Night",
                                "else" : {
                                    $cond : {
                                        "if" : {
                                            $lt : [ "$$h", 12 ]
                                        },
                                        "then" : "Morning",
                                        "else" : {
                                            $cond : {
                                                "if" : {
                                                    $lt : [ "$$h", 18 ]
                                                },
                                                "then" : "Afternoon",
                                                "else" : "Evening"
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }
        },
        "UniqueVisits": {
            "$sum": 1
        },
        "Date": {
            "$first": "$StartTime"
        }
    }
},
{
    "$project": {
        "_id": "$_id.Category",
        "Header": {
            "$concat": [{"$substr": [{"$month": "$Date"}, 0,2]},
                "/",
                {"$substr": [{"$dayOfMonth": "$Date"}, 0, 2]},
                "/",
                {"$substr": [{"$year": "$Date"}, 0, 4]}]
        },
        "Name": {
            "$concat": [
                {
                    "$ifNull": ["$_id.Country","notset"]
                },
                "~",
                {
                    "$ifNull": ["$_id.City","notset"]
                }
            ]
        },
        "UniqueVisits": "$UniqueVisits",            
    }
}
]