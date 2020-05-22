Group g = new Group();

Image i = new Image(new Texture("pathtosomeimage.png"));

VerticalGroup vg = new VerticalGroup();

g.setSize(i.getWidth(), i.getHeight());
vg.setFillParent(true);

g.addActor(i);
g.addActor(vg);

//add stuff to the Vertical Group