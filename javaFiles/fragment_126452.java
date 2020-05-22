val categoryEntryRDD = tweetsFiltered.map( mappedTuple =>
    if mappedTuple._5 == "positive" {
        (mappedTuple._6, 1, 1)
    } else {
        (mappedTyple._6, 1, 0)
    }
}

val reducedRDD = categoryEntryRDD.reduceByKey( x, y => (x._1 + y._1, x._2 + y._2) )