// calculate posx and posy, ensuring they lie within 0-2999:
int posx = (3000+((int)(Player.x / 20))%3000)%3000;
int posy = (3000+((int)(Player.y / 20))%3000)%3000;

// test for overflow:
boolean xOverflow = (posx+screenWidth > 3000);
boolean yOverflow = (posy+screenHeight > 3000);

// draw the image:
drawMyImage(posx,posy);
// if necessary, draw displaced copies:
if(xOverflow) drawMyImage(posx-3000,posy);
if(yOverflow) drawMyImage(posx,posy-3000);
if(xOverflow && yOverflow) drawMyImage(posx-3000,posy-3000);

...

private static void drawMyImage(int x, int y){
    int dx1 = Math.max(-x,0);
    int dy1 = Math.max(-y,0);
    int dx2 = Math.min(3000-x,screenWidth);
    int dy2 = Math.min(3000-y,screenHeight);
    int sx1 = Math.max(x,0);
    int sy1 = Math.max(y,0);
    int sx2 = Math.min(x+screenWidth,3000);
    int sy2 = Math.min(y+screenHeight,3000);
    g.drawImage(SpaceBGLayer0, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null, null);
}