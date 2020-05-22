prices = {2000001,2000000,2000000,2000000};
lastMax = 2000000;
numToSell = 0;
total = 0;
loop:
  iteration 1:
    numToSell = 1;
    total = -2000000  
  iteration 2:
    numToSell = 2;
    total = -4000000  // oh no, we underflowed if we are int, but not long!
  iteration 3:
    total = -4000000 + (2 * 2000000)  // let's take a deeper look at this below
    numToSell = 0;
    lastMax = 20000001
total += 0;