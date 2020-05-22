for ( p1 is a prime in your list, except for the last) {
    if p1 cubed is in your range, add it to the answer
    for (p2 is a prime in your list greater than p1) {
        if p2*p1 is in your range, add it to the answer
        //optimization: break when you know you won't find any more
    }
}
// optimization: calculate the ranges of p1 and p2 to be included 
// before you start each loop
// (probably only worthwhile if you raise the limit to something 
// much larger than 1000)