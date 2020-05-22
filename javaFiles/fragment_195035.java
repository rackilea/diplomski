import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public final class JmxUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JmxUtils.class);

    private JmxUtils() {
    }

    public static <T> T newJmxClient(Class<T> clazz, String objectName, String serviceUrl) {
        return newJmxClient(clazz, objectName, serviceUrl, null, null);
    }

    public static <T> T newJmxClient(Class<T> clazz, String objectName, String serviceUrl, final String user, final String pass) {
        try {
            JMXServiceURL jmxServiceUrl = new JMXServiceURL(serviceUrl);
            Map<String, ?> env = user == null ? null : ImmutableMap.of(JMXConnector.CREDENTIALS, new String[] {user, pass});
            JMXConnector jmxc = JMXConnectorFactory.connect(jmxServiceUrl, env);
            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
            ObjectName mbeanName = new ObjectName(objectName);
            return JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);
        } catch (IOException | MalformedObjectNameException e) {
            throw new RuntimeException("Can not create client for remote JMX " + serviceUrl, e);
        }
    }

    /**
     * @param objName
     *            domain:type=value[,name=value]
     * @param implementation
     * @param mbeanInterface
     * @see ObjectName
     * @see StandardMBean
     */
    public static <I> ObjectInstance registerMBean(String objName, I implementation, Class<I> mbeanInterface) {
        int counter = 0;
        String uniqueSuffix = "";
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        while (true) {
            try {
                ObjectName name = new ObjectName(objName + uniqueSuffix);
                StandardMBean mbean = new StandardMBean(implementation, mbeanInterface);
                return mbs.registerMBean(mbean, name);
            } catch (InstanceAlreadyExistsException e) {
                LOG.trace("JMX instance exists, trying next available", e);
                uniqueSuffix = "" + ++counter;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * @param objName
     * @see ObjectName
     */
    public static void unregisterMBean(String objName) {
        try {
            final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            final ObjectName name = new ObjectName(objName);
            mbs.unregisterMBean(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}