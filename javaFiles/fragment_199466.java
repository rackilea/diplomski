@Entity
@Table(name = "seek")
public class Seek implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Valid
    @OneToOne(mappedBy="seek")
    private Url url;

}