public Sprite(GameView gameView) {
      this.gameView=gameView;
      spritebmp = BitmapFactory.decodeResource(gameView.getResources(),
              R.drawable.sprite_robot);
      this.bmp_width = spritebmp.getWidth();
      this.bmp_height= spritebmp.getHeight();

      this.x = random.nextInt(gameView.getWidth());
      this.y = random.nextInt(gameView.getHeight());
}