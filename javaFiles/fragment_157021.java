@Inject
public Bullet(
    EntityParams entityParams,
    String movableType,
    Map<String, Provider<Movable>> movables,
    Renderable renderable) {
    super(entityParams, movables.get(movableType), renderable);
}