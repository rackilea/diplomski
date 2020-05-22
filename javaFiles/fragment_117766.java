public static ValueEnum valueOf(int value) {
        ValueEnum[] valueEnums = ValueEnum.values();
        for (ValueEnum valueEnum : valueEnums) {
            if (valueEnum.getValue() == value)
            {
                return valueEnum;
            }
        }
        return DEFAULT;
    }