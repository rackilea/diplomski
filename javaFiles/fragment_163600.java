public static void main(String[] args) {
    int[][] array = {
            { 255, 255, 255, 255, 255, 255, 255, 255 },
            { 255, 0, 0, 0, 255, 0, 0, 255 },
            { 255, 255, 0, 0, 0, 255, 255, 255 },
            { 255, 0, 0, 255, 255, 0, 0, 255 },
            { 255, 255, 255, 0, 255, 0, 0, 255 },
            { 255, 0, 255, 0, 0, 0, 0, 255 },
            { 255, 255, 255, 255, 255, 255, 255, 255 }
            };
    StringBuilder result = new StringBuilder();
    int currentValue;
    int startIndex;
    for (int i = 0; i < array.length; i++) {
        if (array[i].length == 0) {
            continue;
        }
        currentValue = array[i][0];
        startIndex = 0;
        for (int j = 1; j < array[i].length; j++) {
            if (currentValue != array[i][j]) {
                updateResult(result, currentValue, i, startIndex, j - 1);
                currentValue = array[i][j];
                startIndex = j;
            }
        }
        updateResult(result, currentValue, i, startIndex, array[i].length - 1);
        result.append("\n");
    }
    System.out.println(result.toString());
}

private static void updateResult(StringBuilder result, int value, int row, int startIndex, int endIndex) {
    if (startIndex == endIndex) {
        addCoordinates(result, row, startIndex);
    } else {
        addCoordinates(result, row, startIndex);
        result.append(" to ");
        addCoordinates(result, row, endIndex);
    }
    result.append(" ");
    switch(value) {
    case 255:
        result.append("up");
        break;
    case 0:
        result.append("down");
        break;
        default:
            System.err.println("Unrecognized value " + value);
    }
    result.append("; ");
}

private static void addCoordinates(StringBuilder result, int row, int column) {
    result.append(row);
    result.append(",");
    result.append(column);
}