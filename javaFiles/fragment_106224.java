{
       "$or": [
           {
               "fetchStatus": { 
                   "$gte": FetchStatus.PROCESS_NLP.getID(),
                   "$lte": fetchStatusParam
               },
               "episodeID": { "$in": episodeIDs }
           },
           {
               "fetchStatus": PROCESSED_FETCH.getID(),
               "isFullTextRet": false
           }
       ]
   }