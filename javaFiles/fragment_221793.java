db.solution.aggregate([ {$redact: {
        "$cond": [{

                "$eq": [{
                        "$ifNull": ["$B", "aaaa"]
                    },
                    "aaaa"
                ]

        }, "$$DESCEND", "$$PRUNE"]
    }}]).pretty()