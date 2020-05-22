@Override
  public Object 
 seed(SharedSessionContractImplementor session) 
  {
  return ( (UserVersionType) userType ).seed( 
  session );
 }