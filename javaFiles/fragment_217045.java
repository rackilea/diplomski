public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Does this even run? if not, set the input processor Gdx.input.setInputProcessor(this) in the create method");
        if(button == Input.Buttons.LEFT){
            Food foods = new Food(new Sprite(flakeFoodTexture));
            foods.setPosition(screenX, Gdx.graphics.getHeight()- screenY);// invert the Y position
            foods.setSize(10,10);// set the size
            food.add(foods);
        }
}