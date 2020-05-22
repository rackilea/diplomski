public class TicketHelperUser
{
    public static void main(String[] args) throws Exception
    {
    for (java.lang.reflect.Method m : TicketHelper.class.getDeclaredMethods())
    {
        System.out.println(m);
    }
    java.lang.reflect.Method method = TicketHelper.class.getDeclaredMethod("getCacheKey", String.class, Ticket.class);
    method.setAccessible(true);
    method.invoke(null, new Object[] {"", new Ticket()});
    }
}

public class TicketHelper
{
    static String getCacheKey(String ticketString, Ticket ticket) 
    {
    return "cacheKey";
    }

}

public class Ticket {}