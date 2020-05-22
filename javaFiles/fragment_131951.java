@Entity
@Table(name = "NET_EVL_TEMPLATE", schema = "NET")
@SequenceGenerator(name = "sequence_db", sequenceName = "NET.SEQ_NET_EVL_TEMPLATE", allocationSize = 1)
@Getter
@Setter
public class Evaluation extends BaseEntity<Long> {
...