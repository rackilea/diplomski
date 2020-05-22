class VerySpecial {

    private static Map<String,VerySpecial> cache;

    public static VerySpecial generate(String data) {
        VerySpecial result = cache.get(data);
        if(result == null) {
            result = new VerySpecial(data);
            cache.put(data,result);
        }
        return result;
    }

    private String data;

    private VerySpecial() { }

    private VerySpecial(String data) { this.data = data}

}