class ClassD implements Consumer<List<ClassA>> {
    List<Consumer<ClassA>> effects = new ArrayList<>();

    void add(Consumer<ClassA> effect) { effects.add(effect); }

    @Override
    public void accept(List<ClassA> theList) {
        for(ClassA theA : theList)
            for(Consumer<ClassA> effect : effects)
                effect.accept(theA);
    }
}