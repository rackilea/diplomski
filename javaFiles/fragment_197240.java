//Vertical plain check - The one dropped must always be on top
if (row - 4 > -1) {
    for(int i=1; i<4;i++){
        if (current[row - i][column] != color) {
            return NONE;
        }
    }
    return color;
}