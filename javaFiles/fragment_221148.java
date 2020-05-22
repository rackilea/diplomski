public static final Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
    @Override
    public void setValue(View object, float value) {
        object.setRotation(value);
    }

    @Override
    public Float get(View object) {
        return object.getRotation();
    }
};