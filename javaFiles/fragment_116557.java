@Entity
@RevisionEntity(UsuarioRevisionListener.class)
public class UsuarioRevisionEntity extends DefaultTrackingModifiedEntitiesRevisionEntity {

    private static final long serialVersionUID = 4211821630661371266L;

    @ElementCollection(fetch=FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name="REVTYPE")
    @MapKeyColumn(name="NAMEID")
    @CollectionTable(name="ENT_REVTYPE", joinColumns=@JoinColumn(name="REV"))
    @Getter @Setter
    private Map<String,RevisionType> entityRevType = new HashMap<>();

    public <T extends Entidade> Optional<RevisionType> getRevType(T entity) {
        return Optional.fromNullable(entityRevType.get(chave(entity.getClass(),entity.getId())));
    }

    public static String chave(Class entityClass, Serializable entityId) {
        return String.format("%s-%s",entityClass.getSimpleName(),entityId.toString());
    }
}