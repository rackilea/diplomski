//following if for moving left
if(grid[y][x+1] isn't out of bounds and right key is pressed and grid[y][x+1]!='X') {
    grid[y][x] = '.'; //removes current position
    x++; //change location
}
//following if for moving right
if(grid[y][x-1] isn't out of bounds and left key is pressed and grid[y][x-1]!='X') {
    grid[y][x] = '.'; //removes current position
    x--; //change location
}
//following if for moving down
if(grid[y+1][x] isn't out of bounds and down key is pressed and grid[y+1][x]!='X') {
    grid[y][x] = '.'; //removes current position
    y++; //change location
}
//following if for moving up
if(grid[y-1][x] isn't out of bounds and up key is pressed and grid[y-1][x]!='X') {
    grid[y][x] = '.'; //removes current position
    y--; //change location
}
if(grid[y][x] == '*') { //when trapped in a pit
    System.out.println("You fell in a pit. Game over.");
} else {
    grid[y][x] = 'P'; //update grid
}