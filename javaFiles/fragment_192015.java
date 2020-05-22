byte[] a = /*Allocated and initialized elsewhere*/;
byte[] b = /*Allocated and initialized elsewhere*/;
int replaceStart = 2; // inclusive
int replaceEnd = 4; // exclusive

byte[] c = new byte[a.length - (replaceEnd - replaceStart) + b.length];
System.arraycopy(a, 0, c, 0, replaceStart);
System.arraycopy(b, 0, c, replaceStart, b.length);
System.arraycopy(a, replaceEnd, c, replaceStart + b.length, a.length - replaceEnd);