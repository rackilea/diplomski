UDF2 geohashConverter = new UDF2<Long, Long, String>() {
    @Override
    public String call(Long latitude, Long longitude) throws Exception {
        // convert here
        return "calculate_hash";
    }
};

UDF1 timehashConverter = new UDF1<Long, String>() {
    @Override
    public String call(Long timestamp) throws Exception {
        // convert here
        return "calculate_hash";
    }
};