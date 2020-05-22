@Table(name = "T_ORGANISATION")
    public class Organisation {

        private static final long serialVersionUID = 5348078630581306005L;

        public static final String COLUMN_ID_ORGANISATION = "ID_ORGANISATION";

        @Id
        @Column(name = COLUMN_ID_ORGANISATION, columnDefinition = "CHAR(32)")
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid")
        private String idOrganisation;

        @Column(name = "LIB_NOM", nullable = false, length=250)
        private String nomOrganisation;

        @Column(name = "LIB_CODE", length=100)
        private String code;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="ID_FICHIER")
        @Index(name = IndexNameUtil.T_ORGANISATION_ID_FICHIER_IDX)
        @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
        private File logo ;

@OneToMany(mappedBy="organisation")
List<Abonne> abonnes;

StringBuilder queryString = new StringBuilder(" FROM Organisation org ")
                .append(" JOIN org.abonnes a ")
                .append(" WHERE org.idOrganisation = a.organisation.idOrganisation ");