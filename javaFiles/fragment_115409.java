public BigInteger(String x) 
{   
    int endLoop = 0;
    list = new LinkedList<char>();
    // have a boolean for negative in your class then multiple by 
    // negative one to your operations if its true.
    if(x.charAt(0) == '-'){
        this.negative = true;
        endLoop = 1;
    }
    list = new LinkedList<char>();
    int i = x.length() - 1;
    while(i >= endLoop) {
        if(!validNumber(x.charAt(i)) //fail 

        list.push(( x.charAt(i)));
        i--;
    }

}

// this checks if it's a number.
boolean validNumber(char n){
    for(int i = 48; i =< 57; i++){
        if(n = i) return true;
    }
    return false;

}