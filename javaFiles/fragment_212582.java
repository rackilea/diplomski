public static <T> Function<String, T> jsonDeSerializer(Class<T> c) {
    return (o) -> {
        try {
            return mapper.readValue(o, c);
        } catch (IOException e) {
            logger.error("json.parse.error object.type={}", 
                   o.getClass().getSimpleName(), e);
            throw new JsonProcessingEx();
        }
    };
}