@Bean(init-method="start", destroy-method="stop")
public org.h2.tools.Server h2WebServer() {
   return org.h2.tools.Server.createWebServer(
      "-web", "-webAllowOthers", "-webPort", "8082"
   )
}