@Entity
@Table(name = "EntityModel")
public class EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_model_id", unique = true, nullable = false)
    private int entityModelId;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationModel organization;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private OrganizationModel account;

}

@Entity
@Table(name = "OrganizationModel")
public class OrganizationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id", unique = true, nullable = false)
    private int organizationId;

    @OneToMany(mappedBy = "organization")
    private Set<EntityModel> organization;

}