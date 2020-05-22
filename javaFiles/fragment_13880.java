boolean isWhite = false;
boolean isWhiteLastLine = isWhite;
for(int x = 0; x < getSize().height; x=x+8){
    for(int y = 0; y < getSize().width; y=y+8){
        if(y == 0){
             isWhiteLastLine = isWhite;
        }
        if(isWhite){
             g2d.setColor(Color.white);
        }else{
             g2d.setColor(Color.LIGHT_GRAY);
        }
        g2d.fillRect(y, x, 8, 8);
        isWhite = !isWhite;
        if(y+8 >= getSize().width){
             isWhite = !isWhiteLastLine;
        }
    }
}