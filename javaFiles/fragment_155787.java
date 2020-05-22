private Texture texture;

public void render(){
    game.batch.begin();
    game.batch.setColor(1,1,1,1);
//In Box2D, the orgin of a body is the center of the body, 
//while in your world the orgin of a sprite is the bottom left corner
//I Box2D the width and the height of a body will be twice the values you entered,
//while in your world the width and the height of a sprite are the exact values you entered.
//Taking all this into account, to draw a sprite above a body you need to :
//1 - center the sprite above the body. Ex : (body.getPosition().x - bodyWidth) for the X position
//2 - draw the sprite at the right size, taking in account the factor 2. Ex : bodyWidth * 2 for the widht of the sprite
//3 - Apply the BOX_TO_WORLD factor to all every sizes and distances
    game.batch.draw(texture,
                    BOX_TO_WORLD * (body.getPosition().x - bodyWidth),
                    BOX_TO_WORLD * (body.getPosition().y - bodyHeight),
                    BOX_TO_WORLD * bodyWidth * 2,
                    BOX_TO_WORLD * bodyHeight * 2);
     game.batch.end();
}