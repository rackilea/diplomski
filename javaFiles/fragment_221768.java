@Entity
@Table(name = "parts_used")
@Getter
@Setter
@NoArgsConstructor
public class PartsUsed {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@JsonSerialize
private Long idPartsUsed;
private int amount;
private String specification;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "part_type_id", referencedColumnName = "idPartType")
private PartType partType;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "amount_type_id", referencedColumnName = "idAmountType")
private AmountType amountType;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "project_id", referencedColumnName = "idProject")
private Project project;


}