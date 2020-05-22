@Entity
@Table(name="sub_groups")
public class SubGroup extends Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
...