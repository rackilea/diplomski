@Data
@Entity
@Table(name ="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotNull
    @Size.List ({
            @Size(min=5, message="The field must be at least {min} characters"),
            @Size(max=100, message="The field must be less than {max} characters")
    })
    private String authority;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable=false)
    private User user;
}