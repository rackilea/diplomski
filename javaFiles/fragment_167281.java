/**
 * {@inheritDoc}
 */
@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
public void doWork(Parameters param) throws ServiceException 
{
    ... do bunch of stuff ..
    myDao1.persist(entity)

    -- Some logic here --

    ... do bunch of stuff ..
    myDao2.persist(entity2)

    if(true)
        throw new ServiceException("random error")
}