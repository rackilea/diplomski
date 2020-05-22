public class ConcreteBuilder extends AbstractBuilder<ConcreteClass, NameSetter> implements NameSetter, Optional{
    public static ValueSetter<NameSetter> getBuilder()
    {
        AbstractBuilder<ConcreteClass, NameSetter> builder = new ConcreteBuilder();
        builder.toBeBuild = new ConcreteClass();
        return builder;
    }

    @Override
    public Optional buildName(String name) {
        this.toBeBuild.setCharacterName(name);
        return this;
    }

    @Override
    public ConcreteClass build() {
        return this.toBeBuild;
    }

    @Override
    public Optional addExtraObject(Object extra) {
        System.out.println("test");
        return this;
    }
}