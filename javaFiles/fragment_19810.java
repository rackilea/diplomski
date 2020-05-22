public class StoredChanges {
    private final Map<Object, Map<String, Object>> changes = new IdentityHashMap<Object, Map<String, Object>>();

    public void storeChange(Object o, String fieldName, Object value) {
        Map<String, Object> changedForObject = changes.get(o);
        if (changedForObject == null)
            changes.put(o, changedForObject = new LinkedHashMap<String, Object>());
        changedForObject.put(fieldName, value);
    }

    public void applyChanges() {
        for (Map.Entry<Object, Map<String, Object>> objectMapEntry : changes.entrySet()) {
            Object o = objectMapEntry.getKey();
            for (Map.Entry<String, Object> fieldChange : objectMapEntry.getValue().entrySet()) {
                String fieldName = fieldChange.getKey();
                try {
                    Method setter = o.getClass().getMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
                    setter.invoke(o, fieldChange.getValue());
                } catch (Exception e) {
                    e.printStackTrace(); // or log it.
                }
            }
        }
        changes.clear();
    }
}