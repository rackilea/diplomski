private Map LoaderMap = new LoaderMap();//instead Hashmap  
    class LoaderMap extends HashMap{
        @Override
        public Object get(Object key) {         
            Object obj = super.get(key);
            if (obj==null){
                boolean disableForUpdate = getSubclassTableSpan() > 1 &&
                        hasSubclasses() &&
                        !getFactory().getDialect().supportsOuterJoinForUpdate();

                switch (key.toString()) {
                case "NONE":
                    obj = createEntityLoader( LockMode.NONE );
                    break;
                case "READ":
                    obj = createEntityLoader( LockMode.READ );                  
                    if (disableForUpdate){
                        put(LockMode.UPGRADE, obj );
                        put(LockMode.UPGRADE_NOWAIT, obj );
                        put(LockMode.UPGRADE_SKIPLOCKED, obj );
                        put(LockMode.FORCE, obj );                                          
                        put(LockMode.PESSIMISTIC_READ, obj );
                        put(LockMode.PESSIMISTIC_WRITE, obj );
                        put(LockMode.PESSIMISTIC_FORCE_INCREMENT, obj );                        
                    }
                    break;
                case "UPGRADE":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.UPGRADE );
                case "UPGRADE_NOWAIT":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.UPGRADE_NOWAIT );
                case "UPGRADE_SKIPLOCKED":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.UPGRADE_SKIPLOCKED );
                case "FORCE":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.FORCE );
                case "PESSIMISTIC_READ":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.PESSIMISTIC_READ );
                case "PESSIMISTIC_WRITE":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.PESSIMISTIC_WRITE );
                case "PESSIMISTIC_FORCE_INCREMENT":
                    if (disableForUpdate)
                        obj = get("READ");                       
                    else
                        obj = createEntityLoader( LockMode.PESSIMISTIC_FORCE_INCREMENT );
                case "OPTIMISTIC":
                    obj = createEntityLoader( LockMode.READ );
                    break;
                case "OPTIMISTIC_FORCE_INCREMENT":
                    obj = createEntityLoader( LockMode.READ );
                    break;
                case "merge":
                    obj = new CascadeEntityLoader( AbstractEntityPersister.this, CascadingActions.MERGE, getFactory() );
                    break;                  
                case "refresh":
                    obj = new CascadeEntityLoader( AbstractEntityPersister.this, CascadingActions.REFRESH, getFactory() );
                    break;  
                default:
                    break;
                }
                put(key, obj);
            }
            return obj;
        }
    }
    //Relational based Persisters should be content with this implementation
    protected void createLoaders() {
        if (true)
            return;
....
       }