private static List<char[]> getDiagonalsList(char[][] arr) {
    List<char[]> ans = new ArrayList<>();
    int height = arr.length;
    int width = arr[0].length;
    int numberOfDiagonals = arr.length + arr[0].length - 1;

    for (int diagonalIdx = 0; diagonalIdx < numberOfDiagonals; diagonalIdx++) {
        int i = Math.max(diagonalIdx - width + 1, 0);
        int j = Math.max(width - diagonalIdx - 1, 0);
        int currentDiagonalLength = Math.min(height - i, width - j);
        int idx = 0;

        char[] charArr = new char[currentDiagonalLength];
        while (i < height && j < width)
            charArr[idx++] = arr[i++][j++];

        ans.add(charArr);
    }

    return ans;
}