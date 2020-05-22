@Entity
@Table(name="items")
class Item {
@Id @GeneratedId private Long id;
@ManyToOne
private Order order;
/* getters setters */
}