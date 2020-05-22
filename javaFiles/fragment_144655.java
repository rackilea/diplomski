Arrays.asList(testArgs).forEach(new Consumer<String>() {        
    @Override
    public void accept(String t) {
        test(t);
    }
});