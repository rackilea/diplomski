//Roll the dice
for (int i=0; i<rolls; i++) {
     die1 = (int)(Math.random()*6) + 1;
     die2 = (int)(Math.random()*6) + 1;
     total = die1 + die2;  
        frequency[total]++;    
}