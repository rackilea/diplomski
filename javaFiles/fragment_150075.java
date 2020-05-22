@Entity
@Table
public class FieldEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "FieldId")
  private Long fieldId;
  @Column(name = "FieldName")
  private String fieldName;
  @Column(name = "Type")
  private String type;
}