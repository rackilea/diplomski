public class XSSMultipartRequestHandler extends CommonsMultipartRequestHandler {

    @Override
    public Hashtable getAllElements() {
        Hashtable table = super.getAllElements();
        for (Object key : table.keySet()) {
            Object value = table.get(key);
            if (value instanceof String[]) {
                String[] arr = (String[]) value;
                String[] newValue = { XSSFilterUtil.removeXSSTokens(arr[0]) };
                table.put(key, newValue);
            }
        }
        return table;
    }

}