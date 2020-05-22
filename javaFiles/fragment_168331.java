private class Player {
    public int id;
    @JsonManagedReference
    public Info info;
}

private class Info {
    public int id;
    @JsonBackReference
    public Player parentPlayer;
}