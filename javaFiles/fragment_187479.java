ArrayList<ItemDate> itemDates = new ArrayList<ItemDate>();
while(postIt.hasNext){
    /* Do stuff */
    if(itemDate.contains(todaysDay)){
        itemDates.add(itemDate);
        /* Do stuff, not notifying */
    }
}

/* Notify using instances in itemDates */