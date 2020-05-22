org.hibernate.persister.entity.AbstractEntityPersister.getIdentitySelectString

public String getIdentitySelectString() {
    //TODO: cache this in an instvar
    return getFactory().getDialect().getIdentityColumnSupport()
            .getIdentitySelectString(
                    getTableName( 0 ),
                    getKeyColumns( 0 )[0],
                    getIdentifierType().sqlTypes( getFactory() )[0]
            );
}