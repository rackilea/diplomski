Map<String,JTextField> map = new HashMap<String,JTextField>();
map.put("field 1", textField1);
...
map.put("field n", textFieldn);

public void setTextField(String id, String value) {
    map.get(id).setText(value);
}