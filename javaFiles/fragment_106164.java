boolean digit1Used = false;
boolean digit2Used = false;
boolean digit3Used = false;
int matchingDigits = 0;
if ( guessDigit1 == lotteryDigit1) {
    matchingDigits++;
    digit1Used = true;
} else if ( guessDigit1 == lotteryDigit2) {
    matchingDigits++;
    digit2Used = true;
} else if ( guessDigit1 == lotteryDigit3) {
    matchingDigits++;
    digit3Used = true;
}

if ( guessDigit2 == lotteryDigit1 && !digit1Used) {
    matchingDigits++;
    digit1Used = true;
} else if ( guessDigit2 == lotteryDigit2 && !digit2Used) {
    matchingDigits++;
    digit2Used = true;
} else if ( guessDigit2 == lotteryDigit3 && !digit3Used) {
    matchingDigits++;
    digit3Used = true;
}

if ( guessDigit3 == lotteryDigit1 && !digit1Used) {
    matchingDigits++;
} else if ( guessDigit3 == lotteryDigit2 && !digit2Used) {
    matchingDigits++;
} else if ( guessDigit3 == lotteryDigit3 && !digit3Used) {
    matchingDigits++;
}