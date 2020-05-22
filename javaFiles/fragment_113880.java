public int RevDigs(int input) {
    if(input < 10) {
        return input;
    }
    else {
        return (input % 10) * (int) Math.pow(10, (int) Math.log10(input)) + RevDigs(input/10);
        /* here we:
           - take last digit of input
           - multiply by an adequate power of ten
             (to set this digit in a "right place" of result)
           - add input without last digit, reversed
        */
    }
}