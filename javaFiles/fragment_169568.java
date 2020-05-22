for(Person p:bidders) {
    // bidders holds Person objects and you are checking for boolean. p.getName() == nameOfBidder will evaluate to true. Perhaps you want to check for name equality first and then contains.
    if (bidders.contains(p.getName()==nameOfBidder)) {
   }
}

for (Item i:allItems ) {
    // allItems holds Item objects and you are checking by name string
    if(!(allItems.contains(i.getName()))){ 

    }
}