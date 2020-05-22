public interface SampleInterfaceA <T extends SampleInterfaceB>{
    public void sampleMethod(T b);
}

public class SampleClassA implements SampleInterfaceA<ClassB>{
    public void sampleMethod(ClassB b){}
}

public class SampleClassB implements SampleInterfaceA<ClassC>{
    public void sampleMethod(ClassC c){}
}