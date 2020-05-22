package utils;

public class ContextListener implements ServletContextListener{

void contextInitialized(ServletContextEvent sce){ // we could call loadFromFile here as well
}

//will be executed at tomcat shutdown
void contextDestroyed(ServletContextEvent sce){
    ServerCounter .getInstance().writeToFile();
}

}