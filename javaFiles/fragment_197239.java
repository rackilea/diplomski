//Horizantal check
//Right side
int connected = 0;
int i = 1;
while (column + i <= columns) {
    if (current[row + i][column] != color) {
        break;
    }else{
        connected++;
    }
    i++;
}   
i = 1;
//left side
while (column - i <= columns) {
    if (current[row - i][column] != color) {
        break;
    }else{
        connected++;
    }
    i++;
}
if(connected >= 4){//total connected
    return color;
}else{
    return NONE;
}