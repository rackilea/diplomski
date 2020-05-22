@Override
public Article get( int id )
{
    Article ret = ( Article ) sessionFactory.getCurrentSession().get( Article.class, id );
    if ( ret == null )
    {
        ret = ( Article ) sessionFactory.getCurrentSession().load( Article.class, id );
    }

    return ret;
}