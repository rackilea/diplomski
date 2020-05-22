function powerSet(originalSet)
   if originalSet is empty, return a set of the empty set  // {{}}  (VERY important it is a set of sets!)
   else
     get the powerSet of the originalSet minus one element //this is the recursive call
     call addElement on that result and the element you took away
     return this result