@Override
public void draw(Batch batch, float parentAlpha) {    
        //!!!!!!!!!!!!!!!Error in this place. Draw() not called from stage
        batch.setColor(getColor());        
        batch.draw(Assets.btnPlayRegion, 0, 0);
}