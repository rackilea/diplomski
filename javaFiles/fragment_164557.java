playBounds = new Rectangle(240, 400, 157, 177);
batcher.drawSprite(
    playBounds.lowerLeft.x + playBounds.width / 2,
    playBounds.lowerLeft.y + playBounds.height / 2, 
    playBounds.width, 
    playBounds.height, 
    Assets.mainMenu
);