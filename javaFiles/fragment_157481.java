@RequestMapping(value = "/")
@Transactional
public String getMainPage( Model model )
{
    Session session = SessionFactoryUtils.openSession(sessionFactory);
    Query query = session.createQuery( "from Period" );
    List<Period> list = query.list();
    System.out.println( list );
    return "MainPage";
}