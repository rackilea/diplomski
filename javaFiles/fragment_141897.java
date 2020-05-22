import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Regiutil 
{
    public static final SessionFactory sf=build();
    public static SessionFactory build()
    {
        SessionFactory s=null;
        try
        {
            s= new AnnotationConfiguration().configure().buildSessionFactory();
            return s;
        }
        catch(Throwable t)
        {

        }
        return s;
    }
    public static SessionFactory getsessionfactory()
    {
        return sf;
    }
}