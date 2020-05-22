interface WithKeyEnum {
    String getKey();
}

enum EnumToMap implements WithKeyEnum {
    ...

    @Override
    public String getKey() {
        return key;
    }
}