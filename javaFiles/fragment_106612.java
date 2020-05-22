class SubMapMatcher extends BaseMatcher<Map<?,?>> {

private Object key;
private Object subMapKey;
private Object subMapValue;

public SubMapMatcher(Object key, Object subMapKey, Object subMapValue) {
    super();
    this.key = key;
    this.subMapKey = subMapKey;
    this.subMapValue = subMapValue;
}

@Override
public boolean matches(Object item) {

    Map<?,?> map = (Map<?,?>)item;

    if (!map.containsKey(key)) {
        return false;
    }

    Object o = map.get(key);

    if (!(o instanceof Map<?,?>)) {
        return false;
    }

    Map<?,?> subMap = (Map<?,?>)o;
    return subMap.containsKey(subMapKey) && subMap.get(subMapKey).equals(subMapValue);
}

@Override
public void describeTo(Description description) {
    description.appendText(String.format("contains %s -> %s : %s", key, subMapKey, subMapValue));
}

public static SubMapMatcher containsSubMapWithKeyValue(String key, String subMapKey, String subMapValue) {
    return new SubMapMatcher(key, subMapKey, subMapValue);
}

}