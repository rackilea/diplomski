@Before
public void setUp()
{
    MyClass my = new MyClass();
    MyManager mgr = mock( MyManager.class );
    my.setManager( mgr );

    // Similar for mymanager2
}