@Entity
@Getter
@Setter
@Table(name="amount_type")
public class AmountType {
@Id
@JsonSerialize
private Long idAmountType;
private String type;
}