class Rectangle 
{
    private float x, y;
    private Animation a;

    public Rectangle(float fx, float fy) {
        this.x = fx;
        this.y = fy;
        FloatSetter floatSetter = new FloatSetter()
        {
            @Override
            public void setFloat(float f)
            {
                this.x = f;
            }
        });
        this.a = new Animation(x, 100, 1000, floatSetter);
    }

    public void update() {
        a.update(); // Update animation
    }
}