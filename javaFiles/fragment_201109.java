void mouseClicked(){
    if (mouseX >= 100 && mouseX <= 100+COLUMNS*tileSize && 
        mouseY >= 60 && mouseY <= 60+ROWS*tileSize){
        mouseoverColour = true;

        int col = (mouseX - 100) / tileSize;
        int row = (mouseY - 60) / tileSize;
        int n = row * COLUMNS + col + 1;

        println(n, ":", row, col);
    }
}