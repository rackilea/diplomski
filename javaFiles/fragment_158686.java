animator.setEvaluator(new TypeEvaluator<Float>() {
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        return (startValue + (endValue - startValue) * fraction);
    }
});