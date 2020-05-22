//Example
Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
int idx = 0;    

//on click, perform the following
tile.setColor(colors[(idx+1)%colors.length]);