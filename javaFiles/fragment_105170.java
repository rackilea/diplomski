public class Holder {
    private Colors colors;
}

public class Colors {
    private Map<String, Item> map;
}

public class Item {
    private String name;
    private int[] base_rgb;
    private Cloth cloth;
    ... // more
}

public class Cloth {
    private int brightness;
    private float contrast;
    private int hue;
    private float saturation;
    private float lightness;
    private int[] rgb;
}