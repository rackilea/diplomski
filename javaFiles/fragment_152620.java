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