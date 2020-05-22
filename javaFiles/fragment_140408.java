enum LetterType {
ONE, TWO, THREE;

private static Map<String, LetterType> stringValues;
static {
    stringValues = new HashMap<>();
    stringValues.put("A", ONE);
    stringValues.put("B", ONE);
    stringValues.put("C", TWO);
    stringValues.put("D", THREE);
}

public static LetterType fromValue(String v) {
    return stringValues.get(v);
}