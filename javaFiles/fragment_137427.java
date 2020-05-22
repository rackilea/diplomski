interface Effect<T> {
    void apply(T theT);
}

Effect<ClassA> classAEffectA = new Effect<>() {
    @Override
    public void apply(ClassA theA) {
        theA.effectA();
    }
};