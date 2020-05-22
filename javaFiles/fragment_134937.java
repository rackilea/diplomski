public Object process(Map.Entry<String, Object> entry) {
        if(null == entry.getValue()) {
            entry.setValue("value123");
        }
        return entry.getValue();
    }