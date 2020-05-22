//
// permissions for the user/principal "controlRole", for all codebases:
//
grant principal com.sun.security.auth.UserPrincipal "controlRole" {

    //
    // jconsole:
    //  - most of these permissions are needed to let JConsole query the 
    //    MBean server and display information about Derby's mbeans as well
    //    as some default platform MBeans/MXBeans.
    //  - if you don't use JConsole, but query the MBean server from your
    //    JMX client app, some of these permissions may be needed.
    permission javax.management.MBeanPermission 
        "sun.management.*#-[java.*:*]", 
        "getMBeanInfo,isInstanceOf,queryNames";
    permission javax.management.MBeanPermission 
        "sun.management.*#*[java.*:*]", "getAttribute,invoke";
    permission javax.management.MBeanPermission 
        "sun.management.*#-[com.sun.management*:*]", 
        "getMBeanInfo,isInstanceOf,queryNames";
    permission javax.management.MBeanPermission 
        "com.sun.management.*#-[java.*:*]", 
        "getMBeanInfo,isInstanceOf,queryNames";
    permission javax.management.MBeanPermission 
        "com.sun.management.*#*[java.*:*]", "getAttribute,invoke";
    permission javax.management.MBeanPermission "java.*#-[java.*:*]", 
        "getMBeanInfo,isInstanceOf,queryNames";
    permission javax.management.MBeanPermission "javax.management.MBeanServerDelegate#[JMImplementation:type=MBeanServerDelegate]", 
        "getMBeanInfo,isInstanceOf,queryNames,addNotificationListener";
    permission java.net.SocketPermission "*", "resolve";
    permission java.util.PropertyPermission "java.class.path", "read";
    permission java.util.PropertyPermission "java.library.path", "read";
    permission java.lang.management.ManagementPermission "monitor";
    // end jconsole
};