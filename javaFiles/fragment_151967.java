@Entity
class Source {
    @Id private Integer id;
    private String name;
    @OneToMany @JoinColumn(name = "source_id") private List<Item> items;
}

@Entity
class Item {
    @Id private Integer id;
    private String name;
}