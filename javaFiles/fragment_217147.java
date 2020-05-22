public class Car {

    private Map<String, Set<String>> carMap = new HashMap<>();

    /**
     * Populate some sample data
     */
    public void populate() {

        Set<String> model = new TreeSet<>();
        model.add("Fiesta");
        model.add("Cougar");
        model.add("Transit");
        carMap.put("Ford", model);

        model = new TreeSet<>();
        model.add("Astra");
        model.add("Calibra");
        carMap.put("Vauxhall", model);

        model = new TreeSet<>();
        model.add("206");
        model.add("106");
        carMap.put("Peugeot", model);

    }

    public void addModel(String makeName, Set<String> aModel) {
        carMap.put(makeName, aModel);
    }

    public Map<String, Set<String>> getCarMap() {
        return carMap;
    }
}