public List<Key> getKeyValues()
{
    return createCriteria()
        .add( Restrictions.lt( "actualID", 3 ) )
        .addOrder( Order.asc( "actualID" ) )
        .list();
}