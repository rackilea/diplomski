if(dir == 0) { // 1
    currentX = currentX; // 0
    currentY -= 1; // -1
} else if(dir == 1) {
    currentX += 1; // 1
    currentY -= 1; // -1
} else if(dir == 2) {
    currentX += 1; // 1
    currentY = 0; // 0
} else if(dir == 3) {
    currentX += 1; // 1
    currentY += 1; // 1
} else if(dir == 4) {
    currentX = currentX; // 0
    currentY += 1;  // 1
} else if(dir == 5) {
    currentX -= 1; // -1
    currentY += 1; // 1
} else if(dir == 6) {
    currentX -= 1; // -1
    currentY = currentY; // 0
} else {
    currentX -= 1; // -1
    currentY -= 1; // -1
}