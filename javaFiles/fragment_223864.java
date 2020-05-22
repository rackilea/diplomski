class RestaurantEmployee {
    private String name;
    private boolean chef;
    private int id;

    public RestaurantEmployee(String name, boolean chef, int id) {
        this.name = name;
        this.chef = chef;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isChef() {
        return chef;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RestaurantEmployee [name=" + name + ", chef=" + chef + ", id=" + id + "]";
    }
}