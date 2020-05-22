long[] s = new long[] {0, 1, 2};
long[] toAppend = { 3, 4, 5 };

long[] tmp = new long[s.length + toAppend.length];
System.arraycopy(s, 0, tmp, 0, s.length);
System.arraycopy(toAppend, 0, tmp, s.length, toAppend.length);

s = tmp;  // s == { 0, 1, 2, 3, 4, 5 }