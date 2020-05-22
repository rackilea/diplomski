@NodeEntity
public abstract class AbstractDomainEntity implements DomainEntity {
    private static final long serialVersionUID = 1L;

@GraphId
private Long nodeId;

@Indexed(unique=true)
String id;

private Date createdDate;
@Indexed
private Date lastModifiedDate;
@Indexed
private String createduser;
private String lastModifieduser;

protected AbstractDomainEntity(String id) {
    this.id = id;
}

protected AbstractDomainEntity() {
}
//gets sets