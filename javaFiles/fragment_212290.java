if(Character.forDigit(Character.getNumericValue('b'), Character.MAX_RADIX) == 'b') {
    // true!
}
if(Character.forDigit(Character.getNumericValue('B'), Character.MAX_RADIX) == 'b') {
    // true!
}


if(Character.getNumericValue('B') == Character.getNumericValue('b')) {
    // true!
}
if((int)('B') == (int)'b') {
    // false
}