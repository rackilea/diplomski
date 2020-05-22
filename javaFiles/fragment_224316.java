ListIterator<Transaction> li = transactions.listIterator(0);
while (li.hasNext()) {
    //your logic goes here

    //if you need to go to the previous place
    if (li.hasPrevious()) {
        li.previous();
        //further logic here...
    }
}