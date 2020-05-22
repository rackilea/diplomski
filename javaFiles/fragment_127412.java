Image image = new Image();

image.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
        System.out.println("You clicked an image...");
    }
});