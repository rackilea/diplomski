@Mapper
public abstract class TestMapper {

    abstract Source toSource(Target target);
    abstract Target totarget(Source source);

    String toString(TestEnum test){
        return test.getCode();
    }
    TestEnum toEnum(String code){
        for (TestEnum testEnum : TestEnum.values()) {
            if(testEnum.equals(code)){
                return testEnum;
            }
        }
        return null;
    }
}

public class Source {    
    String value;    
    public String getValue() {
        return value;
    }    
    public void setValue(String value) {
        this.value = value;
    }    
}

public class Target {
    TestEnum value;
    public TestEnum getValue() {
        return value;
    }
    public void setValue(TestEnum value) {
        this.value = value;
    }
}