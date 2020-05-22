public boolean onSave(Object entity, Serializable id, Object[] state,   
                     String[] propertyNames, Type[] types)   
{
    if ( entity instanceof City) {

        for ( int i=0; i<propertyNames.length; i++ ) {
            if ( "createdOn".equals( propertyNames[i] ) ) {
                state[i] = new Date();
                return true;
            }
        }
    }
    return false;
}