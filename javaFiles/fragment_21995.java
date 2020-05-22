if(Direction == 1) {
    int i = 0;
    if (yPos + number >= width) {
        yPos = width-1;
        i = width-1 - yPos;
    } else {
        yPos = yPos + number;
        i = number;
    }
    if(penStatus == true){
        for(; i > 0; i--){
            Room[xPos][(yPos-i)] = Turtle;
        }
    }
}