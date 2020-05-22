if(currentX < 0 || 
        currentX == rowLength || 
        currentY < 0 || 
        currentY == colLength || 
        grid[currentY][currentX] != word[currentPos]){
    return false;
}