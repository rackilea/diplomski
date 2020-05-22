public static boolean recursiveFind(
        int initialX,
        int initialY,
        int currentX,
        int currentY,
        int dir,
        int currentPos,
        char[] word,
        char[][] grid,
        int rowLength,
        int colLength) {
    // base case is if currentPos == length of word
    if (word.length == currentPos) {
        System.out.println("Initial: " + initialX + " " + initialY);
        System.out.println("Final: " + currentX + " " + currentY);
        return true;
    }

    if (currentX >= 0 && currentX < rowLength && currentY >= 0 && currentY < colLength && grid[currentY][currentX] == word[currentPos]) {
        if (dir == 0) { // 1
            currentX = currentX; // 0
            currentY -= 1; // -1
        } else if (dir == 1) {
            currentX += 1; // 1
            currentY -= 1; // -1
        } else if (dir == 2) {
            currentX += 1; // 1
            currentY = 0; // 0
        } else if (dir == 3) {
            currentX += 1; // 1
            currentY += 1; // 1
        } else if (dir == 4) {
            currentX = currentX; // 0
            currentY += 1; // 1
        } else if (dir == 5) {
            currentX -= 1; // -1
            currentY += 1; // 1
        } else if (dir == 6) {
            currentX -= 1; // -1
            currentY = currentY; // 0
        } else {
            currentX -= 1; // -1
            currentY -= 1; // -1
        }

        return recursiveFind(initialX, initialY, currentX, currentY, dir, currentPos + 1, word, grid, rowLength, colLength);
    }

    return false;

}