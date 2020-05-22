long available = end.getTime() - start.getTime();
long eachSlotSize = available / numOfSlots;

long slot1Start = start.getTime();
long slot1End = start.getTime() + eachSlotSize;

long slot2Start = slot1End ;
long slot2End = slot1End  + eachSlotSize;

//rest you can complete