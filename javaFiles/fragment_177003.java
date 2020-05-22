int[] numList = { 4, 4, 3, 3, 3, 2, 1, 1, 1, 1, -1, -12, -12, -12, -12 };
int[][] newArray = new int[6][2];
int index = 0;

for (int i = 0; i < numList.length;) {
    int count = 0;
    for (int x = 0; x < numList.length; x++)
        if (numList[x] == numList[i]) count++;
    newArray[index][0] = numList[i];
    newArray[index][1] = count;
    index++;
    i += count;
}
for (int x = 0; x < newArray.length; x++) {
    for (int i = 0; i < newArray[0].length; i++)
        System.out.print(newArray[x][i] + " ");
    System.out.println();
}