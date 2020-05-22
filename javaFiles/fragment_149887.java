@Override
public void init(GameContainer container) throws SlickException
{
    this.character = new Image("/home/ronan/Images/20150517010612.jpg");
    this.scale = 0.5f;
    // When you set your center of rotation is is relative to your image ONLY.
    // this will make the center of my image to be the center of the rotation
    // NOTHING more to add
    this.character.setCenterOfRotation((this.character.getWidth()/2)*this.scale, (this.character.getHeight()/2)*this.scale);
}

@Override
public void update(GameContainer container, int delta) throws SlickException
{
    this.rotation +=delta/10;
    this.character.setRotation(this.rotation);
}

public void render(GameContainer container, Graphics g) throws SlickException
{
    // Here I consider that my position is (500,500). then to draw it, I just substract hal the size of my image.
    // It will draw from top-lefft corner but based on my center.
    character.draw(500-(this.character.getWidth()/2)*this.scale, 500 - (this.character.getHeight()/2)*this.scale,this.scale);
}