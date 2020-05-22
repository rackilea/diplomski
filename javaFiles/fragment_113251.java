card1.addListener(new ClickListener() {
     @Override
     public void clicked(InputEvent event, float x, float y) {
          card1.addAction(Actions.moveTo(x_pos, y_pos,t));
    }
});