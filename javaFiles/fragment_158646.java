@Entity
@Table(name = "boards_cards")
public class Board_Card extends BaseEntity implements Serializable {
  @Id
  @ManyToOne
  Board board;
  @Id
  @ManyToOne
  Card card;
  Boolean on_hold;
}