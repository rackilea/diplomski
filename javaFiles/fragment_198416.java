public static Color[][] doOperation(Color[][] imageArray) {
    int multiplier = 2;
    Color[][] newArray = new Color[imageArray.length*2][imageArray[0].length*2];

    for(int i = 0; i < newArray.length; i++)
        for(int j = 0; j < newArray[0].length; j++) {
            newArray[i][j] = imageArray[i/multiplier][j/multiplier];
        }
    return newArray;
}