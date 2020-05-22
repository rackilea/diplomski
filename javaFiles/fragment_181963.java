Set keys = addressBook.keySet();
    for (Iterator i = keys.iterator(); i.hasNext();) {
        String key = (String) i.next();
        String value = (String) addressBook.get(key);
        System.out.println("key=" + key + ", value=" + value);
    }