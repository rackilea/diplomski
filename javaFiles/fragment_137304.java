public static float min(float a, float b) {
    if (a != a) return a;   // a is NaN
    if ((a == 0.0f) && (b == 0.0f) && (Float.floatToIntBits(b) == negativeZeroFloatBits)) {
         return b;
    }
    return (a <= b) ? a : b;
 }