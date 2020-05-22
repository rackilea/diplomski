/** 
 * Only converts Roman numerals I through VII, because that's all we need in music theory... 
 * VIII would be the octave and equal I!
 */
private int romanNumeralToIndex(String romanNumeral) {
    String s = romanNumeral.toLowerCase();
    if (s.startsWith("vii")) { return 6; } 
    else if (s.startsWith("vi")) { return 5; }
    else if (s.startsWith("v")) { return 4; }
    else if (s.startsWith("iv")) { return 3; }
    else if (s.startsWith("iii")) { return 2; }
    else if (s.startsWith("ii")) { return 1; }
    else if (s.startsWith("i")) { return 0; }
    else { return 0; }
}