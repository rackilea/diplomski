interface IBaseEnum {

    String enumVal();

    public static <T extends Enum<T> & IBaseEnum> T 
                 fromString(String strVal, T[] values) {

        if (strVal == null)
            return null;

        for (T myEnum : values) {
            if (myEnum.enumVal().equalsIgnoreCase(strVal)) {
                return myEnum;
            }
        }

        return null;
    }
}