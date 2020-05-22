/**
 * Called when sql string is being prepared. 
 * @param sql sql to be prepared
 * @return original or modified sql
 */
public String onPrepareStatement(String sql);