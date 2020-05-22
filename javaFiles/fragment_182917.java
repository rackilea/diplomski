...
referenceToClass.test(new Consumer<Map<String, Object>() {
    @Override
    public void accept(Map<String, Object> map) {
        Object someObject = map.get("A"); 
    }
});