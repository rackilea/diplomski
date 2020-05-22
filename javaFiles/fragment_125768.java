public enum Type {
CHANGESET,
NEW_TICKET,
TICKET_CHANGED,
CLOSED_TICKET;

private static final Map<String, Type> tracNameMap = new HashMap<String, Type>();
static {
    for (Type t:Type.values()) {
        tracNameMap.put(t.name(), t);
    }
}
public static Type getByTracName(String tn) {
    return tracNameMap.get(tracNameMap);
}