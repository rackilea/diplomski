import javax.management.InstanceAlreadyExistsException;
import javax.management.JMX;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Engine
{
    private static final MyObject OBJ1;
    private static final MyObject OBJ2;

    static
    {
        try
        {
            final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            final ObjectName on1 = new ObjectName("com.example:type=MyObject1");
            final ObjectName on2 = new ObjectName("com.example:type=MyObject2");
            OBJ1 = JMX.newMBeanProxy(mbs, on1, MyObject.class);
            OBJ2 = JMX.newMBeanProxy(mbs, on2, MyObject.class);
        }
        catch (MalformedObjectNameException e) { throw new RuntimeException(e); }
    }

    public MyObject getObj(final int param)
    {
        switch (param)
        {
            case 1:
                return Engine.OBJ1;
            case 2:
                return Engine.OBJ2;
            default:
                throw new IllegalArgumentException(String.format("%d is not a valid object id", param));
        }
    }

    public static class MyObject1 implements MyObjectMBean
    {
        static
        {
            try
            {
                final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
                final ObjectName on1 = new ObjectName("com.example:type=MyObject1");
                mbs.registerMBean(new MyObject1(), on1);
            }
            catch (MalformedObjectNameException e) { throw new RuntimeException(e); }
            catch (NotCompliantMBeanException e) { throw new RuntimeException(e); }
            catch (InstanceAlreadyExistsException e) { throw new RuntimeException(e); }
            catch (MBeanRegistrationException e) { throw new RuntimeException(e); }
        }

        private MyObject1() { /* your interface implementations go here */ }
    }

    public static class MyObject2 implements MyObjectMBean
    {
        static
        {
            try
            {
                final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
                final ObjectName on1 = new ObjectName("com.example:type=MyObject2");
                mbs.registerMBean(new MyObject2(), on1);
            }
            catch (MalformedObjectNameException e) { throw new RuntimeException(e); }
            catch (NotCompliantMBeanException e) { throw new RuntimeException(e); }
            catch (InstanceAlreadyExistsException e) { throw new RuntimeException(e); }
            catch (MBeanRegistrationException e) { throw new RuntimeException(e); }
        }

        private MyObject2() { /* your interface implementations go here */ }
    }

    private static interface MyObjectMBean extends MyObject { /* mbean specific methods go here */ }
    private static interface MyObject { /* your interface methods go here */ }
}