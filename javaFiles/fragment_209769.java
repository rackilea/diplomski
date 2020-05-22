{
    "messages": { 
       "$elemMatch": { 
          "source": 1,
          "date": { 
              "$gte": ISODate("2013-07-25 00:00:00"),
              "$lt": ISODate("2013-07-26 00:00:00")
         }
       }
   }
}