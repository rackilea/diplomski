public class DataSourceProperties {
   ...

   public String determineDriverClassName() {

     if (StringUtils.hasText(this.driverClassName)) {
        Assert.state(driverClassIsLoadable(),
                "Cannot load driver class: " + this.driverClassName);
        return this.driverClassName;
     }
   ...