public static class PayloadData {
    private String authkey;
    private PizzaPlaceTo pizzaPlace;
    private Map<String, List<String>> updates;

    public String getAuthkey() {
        return authkey;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }

    public PizzaPlaceTo getPizzaPlace() {
        return pizzaPlace;
    }

    public void setPizzaPlace(PizzaPlaceTo pizzaPlace) {
        this.pizzaPlace = pizzaPlace;
    }

    public Map<String, List<String>> getUpdates() {
        return updates;
    }

    public void setUpdates(Map<String, List<String>> updates) {
        this.updates = updates;
    }
}