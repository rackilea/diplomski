01:52:07,313 INFO  [JBossASKernel] Created KernelDeployment for: sandbox-services-1.0-SNAPSHOT.jar
01:52:07,313 INFO  [JBossASKernel] installing bean: jboss.j2ee:jar=sandbox-services-1.0-SNAPSHOT.jar,name=EchoBean,service=EJB3
01:52:07,314 INFO  [JBossASKernel]   with dependencies:
01:52:07,314 INFO  [JBossASKernel]   and demands:
01:52:07,314 INFO  [JBossASKernel]  jboss.ejb:service=EJBTimerService
01:52:07,314 INFO  [JBossASKernel]   and supplies:
01:52:07,314 INFO  [JBossASKernel]  Class:com.stackoverflow.q2440956.samples.services.hello.Echo
01:52:07,314 INFO  [JBossASKernel]  jndi:EchoBean/remote-com.stackoverflow.q2440956.samples.services.hello.Echo
01:52:07,314 INFO  [JBossASKernel]  jndi:EchoBean/remote
01:52:07,314 INFO  [JBossASKernel] Added bean(jboss.j2ee:jar=sandbox-services-1.0-SNAPSHOT.jar,name=EchoBean,service=EJB3) to KernelDeployment of: sandbox-services-1.0-SNAPSHOT.jar
01:52:07,315 INFO  [EJB3EndpointDeployer] Deploy AbstractBeanMetaData@a130d1{name=jboss.j2ee:jar=sandbox-services-1.0-SNAPSHOT.jar,name=EchoBean,service=EJB3_endpoint bean=org.jboss.ejb3.endpoint.deployers.impl.EndpointImpl properties=[container] constructor=null autowireCandidate=true}
01:52:07,381 INFO  [SessionSpecContainer] Starting jboss.j2ee:jar=sandbox-services-1.0-SNAPSHOT.jar,name=EchoBean,service=EJB3
01:52:07,382 INFO  [EJBContainer] STARTED EJB: com.stackoverflow.q2440956.samples.services.hello.EchoBean ejbName: EchoBean
01:52:07,412 INFO  [JndiSessionRegistrarBase] Binding the following Entries in Global JNDI:

    EchoBean/remote - EJB3.x Default Remote Business Interface
    EchoBean/remote-com.stackoverflow.q2440956.samples.services.hello.Echo - EJB3.x Remote Business Interface