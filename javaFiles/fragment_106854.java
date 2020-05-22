public class MyStateEnumConverter extends AbstractSingleValueConverter {
    @Override
    public boolean canConvert(Class clazz) {
        return clazz.equals(MyStateEnum.class);
    }

    @Override
    public Object fromString(String parsedText) {
        return MyStateEnum.getMyStateByDesc(parsedText);
    }
}