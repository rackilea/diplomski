@Entity
@Table(name = "T_COMPANY_ACTIVITY")
public class CompanyActivity {

    @Id
    @Column(name = "COM_ACT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "COM_ID")
    private Company company;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ACT_ID")
    private Activity activity;

    private boolean primary;

}