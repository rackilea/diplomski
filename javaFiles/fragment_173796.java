import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

// Get the JVM's local "server" (there should be only one)
MBeanServer mbs = MBeanServerFactory.findMBeanServer(null).get(0);

// Create an "object name" that points to the application's
// context in Tomcat's MXBean tree. You might want to use
// jvisualvm or a similar MBean explorer to locate your
// application to get the exact right syntax for your context
// in the tree. Tomcat version may affect this value.
ObjectName objectName = new ObjectName("Catalina:j2eeType=WebModule,name=//localhost/contextname,J2EEApplication=none,J2EEServer=none");

// Invoke the "reload" method, which will 
mbs.invoke(objectName, "reload", null, null);