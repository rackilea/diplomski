package my.pckg;

import java.util.Properties;

public class App {

      private Properties appProperties;

      public void setAppProperties(Properties appProperties) {
          this.appProperties = appProperties;
      }

      public String toString() {
        return "App (databaseName=" + appProperties.getProperty("database.name") + ")";
      }

}