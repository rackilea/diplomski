@Bean
  def mbeanServer: MBeanServer = {
    val server = if (environment == "development" || environment == "test") {
      val factory = new MBeanServerFactoryBean
      factory.setLocateExistingServerIfPossible(true)
      factory.setRegisterWithFactory(true)
      factory.afterPropertiesSet()
      log.info("using default MBeanServer")
      factory.getObject
    } else {
      val clazz = Class.forName("org.jboss.mx.util.MBeanServerLocator")
      val locateJboss = clazz.getMethod("locateJBoss", List.empty[Class[_]].toArray: _*)
      log.info("using JBoss MBeanServer")
      locateJboss.invoke(null, 
           List.empty[java.lang.Object].toArray: _*).asInstanceOf[MBeanServer]
    }
    log.info("mbeanServer: " + server)
    server
  }