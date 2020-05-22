public static enum SchemeEnum
{
    // Don't really know what colors you actually want
    BASIC(ColorEnum.RED, ColorEnum.GREEN, ColorEnum.ORANGE),
    DARK(ColorEnum.DARK_RED, ColorEnum.DARK_GREEN, ColorEnum.DARK_ORANGE),
    METALLIC(ColorEnum.LIGHT_RED, ColorEnum.LIGHT_GREEN, ColorEnum.LIGHT_ORANGE);

    // nor know how many colors make up a scheme
    public ColorEnum mainColor;
    public ColorEnum secondaryColor;
    public ColorEnum borderColor;

    private SchemeEnum(ColorEnum mainColor, ColorEnum secondaryColor, 
                       ColorEnum borderColor)
    {
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
        this.borderColor = borderColor;
    }
}