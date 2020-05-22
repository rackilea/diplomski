db.campaigns.find({
          lines:{ 
              $elemMatch: {
                     targeting: {
                           $elemMatch: {
                                brand: "PEOPLE"
                                       }
                                }
                          }
            }
})