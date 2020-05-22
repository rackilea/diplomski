UDF2<String, String, String> intersection = new UDF2<String, String, String>() {
    @Override
    public String call(String arg, String arg2) throws Exception {
        String key = inter(arg, arg2);
        return key;
    }

    private String inter(String arg1, String arg2) {
        // this part of the implementation is just to stay in line with the previous part of this answer
        List<String> list1 = Arrays.asList(arg1.split(" "));
        return Stream.of(arg2.split(" ")).filter(list1::contains).collect(Collectors.joining(" "));
    }
};