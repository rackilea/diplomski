public static void main(String[] args) {
    String[] headers = { "request.car.model", "request.car.make", "request.buyer" }; 
    String[] values = { "a", "b", "c" };

    Map<String, Serializable> outer = new HashMap<>();

    for(int i = 0; i < headers.length; i++) {
        String header = headers[i];
        String value  = values[i];

        String[] parts = header.split("\\.");
        Map<String, Serializable> targetMap = outer;
        for(int j = 0; j < parts.length - 1; j++)
            targetMap = (Map<String, Serializable>) targetMap.computeIfAbsent(parts[j], x -> new HashMap<>());
        targetMap.put(parts[parts.length - 1], value);
    }

    System.out.println(outer.get("request"));
}