// Configurations
Integer DEFAULT_ROW_LEN = 61;
Integer NUMBER_OF_ROWS = 1000;
char DEFAULT_ROW_CONTENT = '.';
Double SPEED = 2.8;

// Preparing row of dots
StringBuilder row = new StringBuilder();
for (int i = 0; i < DEFAULT_ROW_LEN; i++) {
    row.append(DEFAULT_ROW_CONTENT);
}

for (int i = 0; i < NUMBER_OF_ROWS; i += SPEED) {

    // Loop progress
    double relativeProgress = i / DEFAULT_ROW_LEN.doubleValue();

    // In projection on a circle
    double circleProgress  = relativeProgress * Math.PI * 2;

    // Remember that sin goes from -1 to +1, but we need to fit the curve within 0 to +1
    double consoleProgress  = (Math.sin(circleProgress) + 1) / 2;

    // Exact index in the row to highlight
    int  exactPosition = (int) (consoleProgress * DEFAULT_ROW_LEN);
    row.setCharAt(exactPosition, 'X');

    // Print current progress and restore defaults
    System.out.println(row);
    row.setCharAt(exactPosition, DEFAULT_ROW_CONTENT);
}