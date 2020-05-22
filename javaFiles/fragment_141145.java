char c = ...;
int width;
switch (UCharacter.getIntPropertyValue(c, UProperty.EAST_ASIAN_WIDTH)) {
    case UCharacter.EastAsianWidth.WIDE:
    case UCharacter.EastAsianWidth.FULLWIDTH:
        width = 2; break;
    default:
        width = 1;
}