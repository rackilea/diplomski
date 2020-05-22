public abstract class Abstract {
    private void motionY(float dt)
    {
        System.out.println("Abstrcat updateMotionY");
    }

    protected void updateMotionY(float deltaTime) {
        motionY(deltaTime);
    }
    public void update(float deltaTime) {
        motionY(deltaTime);
    }
}