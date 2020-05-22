int[][] valueAndIndex = new int[n][2];

//fill array:
valueAndIndex[i][0] = i;
valueAndIndex[i][1] = expectedValues[i];

//sort on values in descending order
Arrays.sort(valueAndIndex, (a, b) -> Integer.compare(b[1], a[1]));

//find n-th index
int n = 3; //3rd largest number
int index = valueAndIndex[n - 1][0];