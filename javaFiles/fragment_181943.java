int middleStart = (myArr.length - 1) / 2;
int middleEnd = (myArr.length - 1) - middleStart;
int elementsToRemove = middleEnd - middleStart + 1;

int[] result = new int[myArr.length - elementsToRemove];
System.arraycopy(myArr, 0, result, 0, middleStart);
System.arraycopy(myArr, middleEnd + 1, result, middleStart, middleStart);