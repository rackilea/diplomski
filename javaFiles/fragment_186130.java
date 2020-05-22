@Entity
public class Project extends ReadWriteRecord {

    @EmbeddedId
    private MandtId mandtId;

    @MapsId("mandtId")
    @OneToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL) // one to one mappings are directly mapped using the project primary keys
    @JoinColumns( {
        @JoinColumn(name=DatabaseBindingIds.PROJECT_TENANT, referencedColumnName=DatabaseBindingIds.PROPERTYSET_TENANT, insertable=false, updatable=false),
        @JoinColumn(name=DatabaseBindingIds.PROJECT_ID, referencedColumnName=DatabaseBindingIds.PROPERTYSET_ID, insertable=false, updatable=false)
    } )
    private PropertySet propertySet;