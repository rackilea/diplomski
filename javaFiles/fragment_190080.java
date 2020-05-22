public static Condition stWithin(Field<?> left, Field<?> right) {
    return DSL.condition("ST_WITHIN({0}, {1})", left, right);
}

public static Field<?> stPolygon(Field<?> geom, int value) {
    return DSL.field("ST_Polygon({0}, {1})", Object.class, geom, DSL.val(value));
}