function compareBits(num1, num2) {
    // score is the number of matching bits
    var score = 0;
    // start with first bit
    var mask = 1;
    // create rotating mask to individually compare each of the lowest 32 bits
    for (var i = 0; i < 32; i++) {
        // if this bit has the same value, increase the score
        if ((num1 & mask) === (num2 & mask)) {
            ++score;
        }
        // advance mask to next bit with shift left operator
        mask = mask << 1;
    }
    return score;
}