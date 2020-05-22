@Override
public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
  if (entity instanceof TenantAuditable) {
    for ( int i=0; i < propertyNames.length; i++ ) {
      if ( "tenantCode".equals( propertyNames[i] ) ) {
        state[i] = currentUser.getTenantCode();
        return true;
      }
    }          
  }
  return false;
}