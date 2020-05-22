HashMap<String, String> users = new HashMap<String, String>();
users.put("1", "John");
users.put("2", "Bob");
users.put("3", "Tom");

Select select = new Select();
for(Iterator<String> i = users.keySet().iterator(); i.hasNext();) {
    String key = i.next();
    select.addItem(key);
    select.setItemCaption(key, users.get(key));
}

String selValue = (String) select.getValue();