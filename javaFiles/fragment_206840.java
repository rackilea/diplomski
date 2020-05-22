interface FloatSetter {
    void setFloat(float f);
}

public class Animation 
{
    private float currValue, targetValue, duration;
    private FloatSetter floatSetter;

    public Animation(
        float currValue, float targetValue, float duration,
        FloatSetter floatSetter) 
    {
        this.currValue = currValue; 
        this.targetValue = targetValue;
        this.duration = duration;
        this.floatSetter = floatSetter;
    }

    public void update() 
    {
        ...
        floatSetter.setFloat(currValue);
    }
}