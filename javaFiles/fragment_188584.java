double[] data = { 2, 4, 6, 7, 8, 9 };
int[] histogram = calcHistogram(data, 0, 10, 4);
// This is a histogram with 4 bins, 0-2.5, 2.5-5, 5-7.5, 7.5-10.
assert histogram[0] == 1; // one point (2) in range 0-2.5
assert histogram[1] == 1; // one point (4) in range 2.5-5.
// etc..