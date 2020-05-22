if( logger.isDebugEnabled() ) {
  logger.debug( "User with account " + 
    user.getAccount() + " failed authentication; " +
    "supplied crypted password " + user.crypt(password) +
    " does not match." );
}