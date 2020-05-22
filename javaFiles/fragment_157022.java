@Inject
public Bullet(
    @Assisted EntityParams entityParams,
    @Assisted String MovableType,
    Map<String, Provider<Movable>> movables,
    Renderable renderable) {
    super(entityParams, movables.get(movableType), renderable);
}