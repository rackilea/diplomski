@Entity
@Table(name = "usuario", schema = "adm")
    @GenericGenerator(name = "CustomSequenceGenerator", 
        strategy = "<....my_package...>.CustomSequenceGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "adm.seq_usuario")
        })
public class UsuarioEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(generator = "CustomSequenceGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuario", unique = true, nullable = false)
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "active")
    private Boolean active;

    // getter and setter ommited
    ....
}