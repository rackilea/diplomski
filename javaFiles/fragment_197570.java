short[][] outerArray = new short[10][]; // Array of references to short arrays
short[] innerArray;                     // Array of shorts
for (int i = 0; i < 10; i++) {
  innerArray = new short[1];
  outerArray[i] = innerArray;
}