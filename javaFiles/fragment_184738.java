public User {
    @OneToMany(targetEntity = Item_x.class, mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ElementDependent
    private List<Item_x> item_x_list = new ArrayList<Item_x>();
}

public Item_x {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = true, updatable = true)
    @Element(name = "user_id", required = false)
    private Users user;
}