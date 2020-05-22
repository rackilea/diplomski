for (int i=0; i<myArray.length; ++i) {
    if (myArray[i] == null) { 
        // we found a blank spot.  use it to hold nextString.
        break;
    } else if (nexString.compareToIgnoreCase(myArray[i]) < 0) { 
        // nextString should be in spot i, so make room for it
        // by shuffling along whatever is in the array at "i" and later
        // by one place, then put nextString into position "i"
        break;
    }
    // otherwise we'll just move to the next position to check
}