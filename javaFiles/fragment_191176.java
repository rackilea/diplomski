@Entity(name = "Company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;

    private String companyName;

    private String companyNumber;

    private String companyEmail;

    private String companyAddress;

    private String companyCity;

    private String companyState;

    private String companyZip;

    @OneToMany
    @JoinColumn(name = "pCompanyId")
    private List<PatientEntity> patientEntities;

    @OneToMany
    @JoinColumn(name = "pCompanyId")
    private List<PlanEntity> planEntities;

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyNumber='" + companyNumber + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", companyState='" + companyState + '\'' +
                ", companyZip='" + companyZip + '\'' +
                '}';
    }
}