group = {$group: {
         _id: null,
         querisAddedSinceLastWeek : { $sum : {$cond: [
                    { $gt : [ meta.created, ISODate("2014-03-30 12:27:50") ] },
                    1, 0 ] }
         },
         queriesWithExpectedResultsCount: { $sum:
                    { $eq : [ data.expectedResults, null ] }, 
                    1, 0 ] }
         },
         totalActiveQueriesCount: { $sum : 1 }
} }