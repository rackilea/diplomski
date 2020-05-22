function countSimilarBitsHamming(num1, num2) {
    // xor sets a bit to 0 if both are the same and 1 if different
    // so if we xor and then negate, we get bits that are the same
    var sameBits = ((~(num1 ^ num2)) & 0xFFFFFFFF) >>> 0;
    sameBits = sameBits - ((sameBits >> 1) & 0x55555555);
    sameBits = (sameBits & 0x33333333) + ((sameBits >> 2) & 0x33333333);
    return (((sameBits + (sameBits >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
}