int i = 1; // 1
try {
     i = -1; // 2
     if (i < 0) throw new NegativeValueException(); // 3
} catch (NegativeValueException e) {  //Thrown exception because the value is negative.  // 4
  //Where is the criteria that catches this exception? // 5
}