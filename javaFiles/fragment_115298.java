@ManyToMany
@JoinTable(name = "V_LoanSecuredUser",
            joinColumns = @JoinColumn(name = "loanAdditionalInfo_id", updatable = false),
            inverseJoinColumns = @JoinColumn(name = "userAuthentication_Id", updatable = false))
@Persister(impl = ReadOnlyCollectionPersister.class)
@Immutable
public class ReadOnlyCollectionPersister extends BasicCollectionPersister {
    public ReadOnlyCollectionPersister(Collection collection,
            CacheConcurrencyStrategy cache, Configuration cfg,
            SessionFactoryImplementor factory) throws MappingException,
            CacheException {
        super(collection, cache, cfg, factory);
    }

    @Override
    protected boolean isRowDeleteEnabled() {
        return false;
    }

    @Override
    protected boolean isRowInsertEnabled() {
        return false;
    }
}