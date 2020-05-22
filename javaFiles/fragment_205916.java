Scanner in = new Scanner(System.in);
int numberOfArrays = in.nextInt();
BaseClass[][] obj = new BaseClass[numberOfArrays][];
for(int i = 0; i < numberOfArrays; ++i) {
  int currArraySize = in.nextInt();
  obj[i] = new DerivedClass[currArraySize];
  for(int j = 0; j < currArraySize; ++j) {
    obj[i][j] = fillCell(obj, i, j);
  }
}