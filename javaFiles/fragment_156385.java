@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public void a()
{
    System.out.println("+++ a()");
    System.out.println("TX status is " + getTXStatus());
    b();
    System.out.println("TX status is " + getTXStatus());
    System.out.println("--- a()");
}

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void b()
{
    System.out.println("+++ b()");
    System.out.println("TX status is " + getTXStatus());
    System.out.println("--- b()");
}