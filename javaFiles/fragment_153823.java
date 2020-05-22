boolean isOrdered = true;

for(q = 0; q < 10; q++){
  if (values[q]>=values[q+1]){
    // in order
    }
  else {
    // not in order
    isOrdered = false;
    break; // we have found a false, so we can quit out of the for loop
    }
  }

if (isOrdered){
  // do something if the array is in order;
  }