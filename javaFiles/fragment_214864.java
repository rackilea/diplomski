public static void main(String[] args) {
    Container lib = new Container("library");
    Container office = new Container("office");

    Container home = new Container("Home");
    Container shelf = new Container("Shelf");

    home.add(shelf);
    lib.add(office);
    lib.add(home);

    Gson gson = new Gson();
    // Serialize
    String json = gson.toJson(lib);

    // Deserialize
    Container container = gson.fromJson(json, Container.class);

    System.out.println(container.getName());
    for (Container c : container.getContainerList()) {
        System.out.println("-- " + c.getName());
    }
}