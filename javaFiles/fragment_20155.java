public Platform(Sprite spr) {
super(spr);
player = Player.getInstance(null); // Initialises the Player class (a Singleton)
// Set position of sprite
setxPos(getWidth() - 400);
setyPos(getHeight() / 2 - 100);
spr.setX(getxPos()); 
spr.setY(getyPos()); 

//add

// Rectangle of Player
playerRect = new Rectangle(player.getxPos(), player.getyPos(),
                           player.getSprite().getWidth(),
                           player.getSprite().getHeight());

// Rectangle of Platform
platformRect = new Rectangle(getxPos(), getyPos(), 
                             getSprite().getWidth(), 
                             getSprite().getHeight());
}