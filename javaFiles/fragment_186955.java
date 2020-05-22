public class databaseConfiguration extends Configuration {

@Valid
@NotNull
@JsonProperty
DatabaseConfiguration dbconfigurations = new DatabaseConfiguration();

public DatabaseConfiguration getDatabaseConfiguration() {
    //return dbconfigurations;
    Map<String,String> s=new HashMap<String,String>();
    s.put("hibernate.dialect","Hibernate.SQLightDialect.SQLiteDialect");
    dbconfigurations.setProperties(s);
    return dbconfigurations;
}
}