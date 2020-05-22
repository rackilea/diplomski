@Entity
@Table(name = "migrations")
public class Migration {
    @Id
    private Long mignum;
    private LocalDate productiondate;
    private String installationtiers;
    private String targetplatform;
    private String apprelated;
    private String appversion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mignum")
    private MigrationState state;

    // Getters + Setters
}

@Entity
@Table(name = "migration_states")
public class MigrationState {
    @Id
    private Long mignum;
    private String state;
    private String projectleader;

    // Getters + Setters
}