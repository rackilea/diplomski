public Animation walking;

public void initAnims() {
    walking= new Animation(1/10f,
        atlas.findRegion("1"),
        atlas.findRegion("2"),
        atlas.findRegion("3"),
        atlas.findRegion("4"),
        atlas.findRegion("5"),
        atlas.findRegion("6"),
        atlas.findRegion("7"), 
        atlas.findRegion("8"),
        atlas.findRegion("9"),
        atlas.findRegion("10"));
        walking.setPlayMode(Animation.LOOP);

//Init other anims here
}