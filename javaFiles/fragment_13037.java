for(int x = lower; x <= upper; x++) {
    decider = true;
    for (int y = 2; y < x; y ++) {   // can probably make this bound even tighter
        if (x % y == 0) {
            decider = false;
            break;
        }
    }
    if (decider)
        primeNumbers.add(x); 
}
return primeNumbers;