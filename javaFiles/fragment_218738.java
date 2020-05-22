for (...) {
   float next = scan.nextFloat();
   // if greater than max, then it's the new max and the old max is the 2nd
   if (next > maxNumb) {
     secondMax = maxNumb;
     maxNumb = next;
   }
   // if it's only greater than the second, then it's the new second.
   else if (next > secondMax) {
     secondMax = next;
   }
}