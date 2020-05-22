Map<String, Double> hMap = new HashMap<>();

    for (int i = 0; i < keys.size(); i++) {
        String key = keys.get(i);
        String value = values.get(i).isEmpty() ? "0" : values.get(i).replaceAll("%", "");
        Double valueInDouble = Double.valueOf(value);
        hMap.put(key, valueInDouble);

}