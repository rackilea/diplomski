int[] numList = { 6, 6, 5, 5, 4, 4, 3, 2, 1, 1, 1, 7, 6, 5, 7, 8, 65, 65, 7 };
int[][] newArray = new int[1][2];
int index = 0;
for (int i = 0; i < numList.length;) {
    try {
        int count = 0;
        boolean isUnique = true;
        for (int x = 0; x < i; x++)
            if (numList[x] == numList[i]) {
                isUnique = false;
                break;
            }
        if (isUnique) {
            for (int x = 0; x < numList.length; x++)
                if (numList[x] == numList[i]) count++;
            newArray[index][0] = numList[i];
            newArray[index][1] = count;
            index++;
        }
        i++;
    } catch (ArrayIndexOutOfBoundsException e) {
        int tmpArray[][] = newArray;
        newArray = new int[tmpArray.length + 1][tmpArray[0].length];
        for (int row = 0; row < tmpArray.length; row++)
            for (int col = 0; col < 2; col++)
                newArray[row][col] = tmpArray[row][col];
    }
}
for (int x = 0; x < newArray.length; x++) {
    for (int i = 0; i < newArray[0].length; i++)
        System.out.print(newArray[x][i] + " ");
    System.out.println();
}