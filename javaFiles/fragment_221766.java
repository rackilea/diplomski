@Data
@Entity
@Table(name="part_type")
public class PartType {
@Id
@JsonSerialize
private Long idPartType;
private String type;

}