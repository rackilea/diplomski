public void constructdata(){
    try {
        container.putField(key, validitem(param));
    } catch (Exception e) {
        // Handle exception
    }
}

public validitem(String item) throws Exception {
    if (item.equals("Apple") {
        return item;
    }
    if (item.equals("Ball") {
        return item;
    }
    throw new Exception("Error message");
}