public class ItemInfo implements Serializable {

    @Column(name = "name")
    private String name;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", nullable = false)
    private Item itemId;

    @ManyToOne
    @JoinColumn(name = "language_item_id",**referencedColumnName = "item_id"**)
    private Language languageItemId;

    @Column(name = "type", nullable = false)
    private Integer type;
}