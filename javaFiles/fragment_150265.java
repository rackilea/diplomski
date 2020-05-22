public static class MyAdapter implements JsonbAdapter<MyEnum, String> {

    @Override
    public String adaptToJson(MyEnum value) {
        return value.name();
    }

    @Override
    public MyEnum adaptFromJson(String s) {
        return MyEnum.valueOf(s.toUpperCase());
    }
}