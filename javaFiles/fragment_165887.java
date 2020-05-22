private int id;

    private String name;

    private User user;

    private List<HashMap<String, ItemsBean>> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<HashMap<String, ItemsBean>> getItems() {
        return items;
    }

    public void setItems(List<HashMap<String, ItemsBean>> items) {
        this.items = items;
    }
}