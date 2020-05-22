// looping through the restoraunts
for(Restaurant resto : restoraunts){
    // looping through the dates of the restaurant, given you have a getter for the Date object
    for(Date date : resto.getDate()){
        // now we have a date, let's compare it to all the other dates
        for(Restaurant resto_bis : restoraunts){
             for(Date date_bis : resto_bis.getDate()){
                 if (date_bis != date)
                     if (date.compateTo(date_bis) == 0) raise new NameDuplicateException()
             }
        }
    }
}