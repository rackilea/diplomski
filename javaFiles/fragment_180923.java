public static class YourAnimation {
    public ModelInstance instance;
    public final Vector3 fromPosition = new Vector3();
    public float fromAngle;
    public final Vector3 toPosition = new Vector3();
    public float toAngle;
    public float speed;
    public float alpha;
    private final static Vector3 tmpV = new Vector3();

    public void update(float delta) {
        alpha += delta * speed;
        if (alpha >= 1f) {
            alpha = 1f;
            // TODO: do whatever you want when the animation if complete
        }
        angle = fromAngle + alpha * (toAngle - fromAngle);
        instance.transform.setToRotation(Vector3.Y, angle);
        tmpV.set(fromPosition).lerp(toPosition, alpha);
        instance.transform.setTranslation(tmpV);
    }
}

YourAnimation animation = null;

void animate(ModelInstance instance) {
    animation = new YourAnimation();
    animation.instance = instance;
    animation.instance.transform.getTranslation(animation.fromPosition);
    animation.toPosition.set(animation.fromPosition).add(10f, 10f, 10f);
    animation.fromAngle = 0;
    animation.toAngle = 90f;
    animation.speed = 1f; // 1 second per second
    animation.alpha = 0;
}

public void render() {
    final float delta = Math.min(Gdx.graphics.getDeltaTime(), 1/30f);
    if (animation != null)
        animation.update(delta);
    // render model as usual etc.
}