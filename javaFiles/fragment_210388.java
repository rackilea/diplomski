for (int i = 0; i < 20; i++) {
    if (Gdx.input.isTouched(i)) {
      float x = Gdx.input.getX(i) / (float) Gdx.graphics.getWidth();
      float y = Gdx.input.getY(i) / (float) Gdx.graphics.getHeight();
      if ((x >= startX && x <= endX) && (y>=startY && y<= endY)) {
          return true;
      }
}
return false;