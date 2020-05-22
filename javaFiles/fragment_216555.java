int x = -57;

// step 1:
long xCast = (long) x;
System.out.println(Long.toString(xCast, 2)); // -1110011 - this is not the bitwise representation however.

long mask = 0xffffffffL;
System.out.println(Long.toString(mask, 2)); // 11111111111111111111111111111111

// step 2:
long result = ((long) x) & mask;
System.out.println(Long.toString(result, 2)); // 11111111111111111111111111000111