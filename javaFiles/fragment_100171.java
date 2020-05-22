public boolean onFlushDirty(Object entity,Serializable id,Object[] currentState, 
                  Object[] previousState,String[] propertyNames, Type[] types) 
{

    if ( entity instanceof City ) {

        for ( int i=0; i < propertyNames.length; i++ ) {
            if ( "lastUpdatedOn".equals( propertyNames[i] ) ) {
                currentState[i] = new Date();
                return true;
            }
        }
    }
    return false;
}