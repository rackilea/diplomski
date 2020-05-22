@Entity
@SqlResultSetMapping(name = "compositekey", entities = @EntityResult(entityClass = MiniBar.class, fields = { @FieldResult(name = "miniBar", column = "BAR_ID"), }))
@NamedNativeQuery(name = "compositekey", query = "select BAR_ID from BAR", resultSetMapping = "compositekey")
@Table(name = "BAR")
public class MiniBar {
    @Id
    @Column(name = "BAR_ID")
    Long barId;
}