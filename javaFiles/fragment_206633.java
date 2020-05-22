contains() is used to check for containment: e.g.

 Ranges.closed(2,4).contains(2);    // returns true
 Ranges.open(2,4).contains(2);      // returns false
 Ranges.atLeast(2).contains(2);     // returns true
 Ranges.greaterThan(2).contains(2); // returns false
 Ranges.atMost(2).contains(2);      // returns true
 Ranges.lessThan(2).contains(2);    // returns false