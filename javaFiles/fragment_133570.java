@IdClass(ContenusPK.class)
@Entity
@TableName(name="")
public class Contenus {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "GENERATOR_NAME")
    @SequenceGenerator(
        name = "GENERATOR_NAME", 
        sequenceName = "SEQUENCE NAME IN DB")
    @Column(name = "CONTENUS_ID")
    private Long id;

    @Id
    @Column(name = "LANGUE")
    private String langue;

    ...
}