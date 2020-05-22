@Override
public void draw(Batch batch, float alpha){
    batch.draw(rectangleSprite,
               rectangleSprite.getX(), 
               rectangleSprite.getY(),
               rectangleSprite.getOriginX(),
               rectangleSprite.getOriginY(),
               rectangleSprite.getWidth(),
               rectangleSprite.getHeight(),
               rectangleSprite.getScaleX(),
               rectangleSprite.getScaleY(),
               rectangleSprite.getRotation());
}