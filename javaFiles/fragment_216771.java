if (nm.startsWith("0x", index) || nm.startsWith("0X", index)) {
    index += 2;
    radix = 16;
} else if (nm.startsWith("#", index)) {
    index ++;
    radix = 16;
} else if (nm.startsWith("0", index) && nm.length() > 1 + index) {
    index ++;
    radix = 8;
}