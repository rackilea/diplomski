public interface BuilderClass<O, P>{
    O build(P parameter);
}

public class BuilderSpecificClass<SpecificClass, Object>{
    @Override
    public SpecificClass build(Object parameter){
        return new SpecificClass(parameter);
    }
}