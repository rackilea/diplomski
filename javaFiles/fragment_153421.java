class Row<T extends Enum<T>> {
    EnumMap<T, Object> map;
    Class<T> enumType;

    public Row(Class<T> enumType){
        this.enumType = enumType;
    }

    void showEnums(){
        for (T col : enumType.getEnumConstants())
            System.out.println(col);
    }
}