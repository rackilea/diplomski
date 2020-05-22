@Before
public void createCleanDb() {
    Ebean.execute(Ebean.createCallableSql(dropDdl));
    Ebean.execute(Ebean.createCallableSql(createDdl));
    //Create initial data
    Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
    Ebean.save(all.get("criteria"));
    Ebean.save(all.get("scoringmodels"));
}