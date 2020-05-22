public enum PublicEnum {
    PUBLIC_VALUE_1 (PackagePrivateEnum.PUBLIC_VALUE_1),
    PUBLIC_VALUE_2 (PackagePrivateEnum.PUBLIC_VALUE_2),
    PUBLIC_VALUE_3 (PackagePrivateEnum.PUBLIC_VALUE_3);

    final PackagePrivateEnum value;

    private PublicEnum(PackagePrivateEnum value) {
        this.value = value;
    }
}