function countBitsString(num1, num2) {
    // xor sets a bit to 0 if both are the same and 1 if different
    // so if we xor and then negate, we get bits that are the same
    var sameBits = ((~(num1 ^ num2)) & 0xFFFFFFFF) >>> 0;
    var str = sameBits.toString(2).replace(/0/g, "");
    return str.length;
}