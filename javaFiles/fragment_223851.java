public class ContextSourceAndJpaTransactionManager extends JpaTransactionManager
{

private static final long serialVersionUID = 1L;

private ContextSourceTransactionManagerDelegate ldapManagerDelegate =
        new ContextSourceTransactionManagerDelegate();

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#isExistingTransaction(Object)
 */
protected boolean isExistingTransaction(Object transaction)
{
    ContextSourceAndJpaTransactionObject actualTransactionObject =
            (ContextSourceAndJpaTransactionObject) transaction;

    return super.isExistingTransaction(actualTransactionObject
                                               .getJpaTransactionObject());
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doGetTransaction()
 */
protected Object doGetTransaction() throws TransactionException
{
    Object dataSourceTransactionObject = super.doGetTransaction();
    Object contextSourceTransactionObject =
            ldapManagerDelegate.doGetTransaction();

    return new ContextSourceAndJpaTransactionObject(
            contextSourceTransactionObject, dataSourceTransactionObject
    );
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doBegin(java.lang.Object,
 *      org.springframework.transaction.TransactionDefinition)
 */
protected void doBegin(Object transaction, TransactionDefinition definition)
        throws TransactionException
{
    ContextSourceAndJpaTransactionObject actualTransactionObject =
            (ContextSourceAndJpaTransactionObject) transaction;

    super.doBegin(actualTransactionObject.getJpaTransactionObject(),
                  definition);
    ldapManagerDelegate.doBegin(
            actualTransactionObject.getLdapTransactionObject(),
            definition
    );
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doCleanupAfterCompletion(java.lang.Object)
 */
protected void doCleanupAfterCompletion(Object transaction)
{
    ContextSourceAndJpaTransactionObject actualTransactionObject =
            (ContextSourceAndJpaTransactionObject) transaction;

    super.doCleanupAfterCompletion(actualTransactionObject
                                           .getJpaTransactionObject());
    ldapManagerDelegate.doCleanupAfterCompletion(actualTransactionObject
                                                 .getLdapTransactionObject());
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doCommit(org.springframework.transaction.support.DefaultTransactionStatus)
 */
protected void doCommit(DefaultTransactionStatus status)
        throws TransactionException
{

    ContextSourceAndJpaTransactionObject actualTransactionObject =
            (ContextSourceAndJpaTransactionObject) status.getTransaction();

    try
    {
        super.doCommit(new DefaultTransactionStatus(
                actualTransactionObject.getJpaTransactionObject(),
                status.isNewTransaction(),
                status.isNewSynchronization(),
                status.isReadOnly(),
                status.isDebug(),
                status.getSuspendedResources())
        );
    }
    catch (TransactionException ex)
    {
        if (isRollbackOnCommitFailure())
        {
            logger.debug("Failed to commit db resource, rethrowing", ex);
            // If we are to rollback on commit failure, just rethrow the
            // exception - this will cause a rollback to be performed on
            // both resources.
            throw ex;
        }
        else
        {
            logger.warn(
                    "Failed to commit and resource is rollbackOnCommit not set -"
                            + " proceeding to commit ldap resource.");
        }
    }
    ldapManagerDelegate.doCommit(new DefaultTransactionStatus(
            actualTransactionObject.getLdapTransactionObject(),
            status.isNewTransaction(),
            status.isNewSynchronization(),
            status.isReadOnly(),
            status.isDebug(),
            status.getSuspendedResources())
    );
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doRollback(org.springframework.transaction.support.DefaultTransactionStatus)
 */
protected void doRollback(DefaultTransactionStatus status) throws TransactionException
{
    ContextSourceAndJpaTransactionObject actualTransactionObject =
            (ContextSourceAndJpaTransactionObject) status.getTransaction();

    super.doRollback(new DefaultTransactionStatus(
            actualTransactionObject.getJpaTransactionObject(),
            status.isNewTransaction(),
            status.isNewSynchronization(),
            status.isReadOnly(),
            status.isDebug(),
            status.getSuspendedResources())
    );
    ldapManagerDelegate.doRollback(new DefaultTransactionStatus(
            actualTransactionObject.getLdapTransactionObject(),
            status.isNewTransaction(),
            status.isNewSynchronization(),
            status.isReadOnly(),
            status.isDebug(),
            status.getSuspendedResources())
    );
}

@SuppressWarnings("UnusedDeclaration")
public ContextSource getContextSource()
{
    return ldapManagerDelegate.getContextSource();
}

public void setContextSource(ContextSource contextSource)
{
    ldapManagerDelegate.setContextSource(contextSource);
}

@SuppressWarnings("UnusedDeclaration")
protected void setRenamingStrategy(TempEntryRenamingStrategy renamingStrategy)
{
    ldapManagerDelegate.setRenamingStrategy(renamingStrategy);
}

private final static class ContextSourceAndJpaTransactionObject
{
    private Object ldapTransactionObject;

    private Object jpaTransactionObject;

    public ContextSourceAndJpaTransactionObject(
            Object ldapTransactionObject, Object jpaTransactionObject)
    {
        this.ldapTransactionObject = ldapTransactionObject;
        this.jpaTransactionObject = jpaTransactionObject;
    }

    public Object getJpaTransactionObject()
    {
        return jpaTransactionObject;
    }

    public Object getLdapTransactionObject()
    {
        return ldapTransactionObject;
    }
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doSuspend(java.lang.Object)
 */
protected Object doSuspend(Object transaction) throws TransactionException
{
    throw new TransactionSuspensionNotSupportedException(
            "Transaction manager [" + getClass().getName()
                    + "] does not support transaction suspension");
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doResume(java.lang.Object, java.lang.Object)
 */
protected void doResume(Object transaction, Object suspendedResources)
        throws TransactionException
{
    throw new TransactionSuspensionNotSupportedException(
            "Transaction manager [" + getClass().getName()
                    + "] does not support transaction suspension");
}

/**
 * @see org.springframework.orm.jpa.JpaTransactionManager#doSetRollbackOnly(org.springframework.transaction.support.DefaultTransactionStatus)
 */
@Override
protected void doSetRollbackOnly(DefaultTransactionStatus status)
{
    super.doSetRollbackOnly(
            new DefaultTransactionStatus(
                ((ContextSourceAndJpaTransactionObject)status.getTransaction())
                        .getJpaTransactionObject(),
                status.isNewTransaction(),
                status.isNewSynchronization(),
                status.isReadOnly(),
                status.isDebug(),
                status.getSuspendedResources())

    );
}
}