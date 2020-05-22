enum ClassAEffect {
    A { @Override void apply(ClassA theA) { theA.effectA(); } },
    B { @Override void apply(ClassA theA) { theA.effectB(); } },
    C {
        @Override
        void apply(ClassA theA) {
            theA.effectC();
        }
    };

    abstract void apply(ClassA theA);
}

class ClassD {
    List<ClassAEffect> effects = new ArrayList<>();

    void add(ClassAEffect effect) { effects.add(effect); }

    void apply(List<ClassA> list) {
        for(ClassA theA : list)
            for(ClassAEffect effect : effects)
                effect.apply(theA);
    }
}