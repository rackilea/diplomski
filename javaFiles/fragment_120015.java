private World world;
private ContactListener contactlistener;

public Play(GameStateManager gsm) {
    super(gsm);
    world = new World(new Vector2(0, -1), true);
    contactlistener = new MyContactListener(); // XXX
    world.setContactListener(contactlistener);