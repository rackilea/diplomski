1. Book book = (Book) session.get(Book.class, "DOES_NOT_EXIST"); 
2. SessionImpl.get
   public Object get(Class entityClass, Serializable id) throws HibernateException {
        return get( entityClass.getName(), id );
    }
3. fireLoad(event, LoadEventListener.GET);
4. DefaultLoadEventListener.onLoad
 //return a proxy if appropriate
            if ( event.getLockMode() == LockMode.NONE ) {
                event.setResult( proxyOrLoad(event, persister, keyToLoad, loadType) );
            }
5. DefaultLoadEventListener.proxyOrLoad
 if ( proxy != null ) {
            return returnNarrowedProxy( event, persister, keyToLoad, options, persistenceContext, proxy );
        }
6. DefaultLoadEventListener.returnNarrowedProxy
if ( !options.isAllowProxyCreation() ) {
            impl = load( event, persister, keyToLoad, options );
            if ( impl == null ) {
                event.getSession().getFactory().getEntityNotFoundDelegate().handleEntityNotFound( persister.getEntityName(), keyToLoad.getIdentifier());
            }
        }
 7. SessionFactoryImpl.handleEntityNotFound
// EntityNotFoundDelegate
        EntityNotFoundDelegate entityNotFoundDelegate = cfg.getEntityNotFoundDelegate();
        if ( entityNotFoundDelegate == null ) {
            entityNotFoundDelegate = new EntityNotFoundDelegate() {
                public void handleEntityNotFound(String entityName, Serializable id) {
                    throw new ObjectNotFoundException( id, entityName );
                }
                public boolean isEntityNotFoundException(RuntimeException exception) {
                    return ObjectNotFoundException.class.isInstance( exception );
                }
            };
        }