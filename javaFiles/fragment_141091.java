@Override
public void draw(Batch batch, float parentAlpha){      
  batch.draw(texture, this.getX(), this.getY(), this.getOriginX(),this.getOriginY(), texture.getRegionWidth(), texture.getRegionHeight(), this.getScaleX(), this.getScaleY(),this.getRotation());

  applyTransform(batch, computeTransform());

  drawChildren(batch, parentAlpha);

  resetTransform(batch);
}