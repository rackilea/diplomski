public class MyEnumConverter extends StringConverter<MyEnum>{

    @Override public String toString(MyEnum enumConstant) {
        return enumConstant.getName();
    }

    @Override public MyEnum fromString(String string) {
        return MyEnum.valueOf(string);
    }
}