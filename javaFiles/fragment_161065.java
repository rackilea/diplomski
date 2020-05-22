{
// stop the timer
qTimer[q].stop();

// peek at how many items the customer has, and set the delay.
qTimer[q].setInitialDelay(customerQueue[q].peek().getItems()*_SECONDS_PER_ITEM);

// the next time around, this method will see the flag, and dequeue the customer.
working[q] = true;

// denote that the customer is active on the UI.
lblCustomer[q][0].setBorder(new LineBorder(Color.RED, 2));

// start the timer.
qTimer[q].start();

}