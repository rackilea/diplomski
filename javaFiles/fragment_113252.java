card1.addListener(new DragListener(){
    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        card1.moveBy(x - card1.getWidth() / 2, y - card1.getHeight() / 2);
        super.drag(event, x, y, pointer);
    }
});