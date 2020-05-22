@Entity
         public class Item {
              @Id
              @GeneratedValue(strategy = GenerationType.AUTO)
              @Column(name = "Item_ID")
               private Long itemId;

              @ElementCollection
              @CollectionTable(name="ITEM_IMAGE",     joinColumns=@JoinColumn(name="ITEM_ID"))
              @MapKeyColumn(name="ITEM_ID")
              private Map<String, Image> contacts = new HashMap<String, Image>();
              }

              @Embeddable
              public class Image {
               //Specify your composite attributes with the column name for each
              }