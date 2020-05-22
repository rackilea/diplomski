public class ExceptionLegacyObject implements LegacyObject {
    @Override
    public Integer getAge() {
        return 40;
    }

    @Override
    public String getDesc() {
        return "some description";
    }

    @Override
    public String getName() {
        throw new RuntimeException();
    }
}