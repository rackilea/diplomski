final Image img = pic.get(0);
final float prevX = img.getX(), prevY = img.getY();

img.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
        System.out.println("CLICKED!!!");
        if(img.getX() != prevX || img.getY() != prevY)
            img.addAction(Actions.moveTo(prevX, prevY));
        else
            img.addAction(Actions.moveTo(300,700));
    }
});