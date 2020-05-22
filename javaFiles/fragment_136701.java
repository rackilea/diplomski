int a = 5;
a += 1.5f;
// a == 6

char ch = '0'; // (char) 49
ch *= 1.1;     // ch = '4';

long l = Integer.MAX_VALUE;
l += 0.0f;   // i = (long ) ((long ) l + 0.0f)
// i == Integer.MAX_VALUE + 1L; WTF!?
// l is no longer Integer.MAX_VALUE due to rounding error.