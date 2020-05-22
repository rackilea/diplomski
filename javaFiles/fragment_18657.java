public static HashMap<Integer, Double> findIncomes(HashMap<Integer, ArrayList<Element>> mapa){
    HashMap<Integer, Double> sumsByKey = new HashMap<>();
    mapa.entrySet().stream().forEach(entry -> sumsByKey.put(entry.getKey(),
        entry.getValue().stream().map(element -> BigDecimal.valueOf(element.getPrice())).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue()));
    return sumsByKey;
}