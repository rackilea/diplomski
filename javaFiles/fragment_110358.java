private Database<?> database;
private Configuration configuration;
private int order = 0;

public MyMigrationResolver(Database<?> database, Configuration configuration) {
    this.database = database;
    this.configuration = configuration;
}

@Override
public Collection<ResolvedMigration> resolveMigrations() {

    Collection<ResolvedMigration> scripts = new LinkedList<ResolvedMigration>();
    scripts.add(script(folder1\\somescript.dml"));
    scripts.add(script("folder2\\someOtherScript.sql"));

    return scripts;
}

private ResolvedMigrationImpl script(String scriptName) {


    String baseFolder = "target\\scripts\\";
    order++;

    ResolvedMigrationImpl migration = new ResolvedMigrationImpl();
    migration.setScript(baseFolder+scriptName);
    migration.setType(MigrationType.SQL);
    migration.setDescription(""+String.format("%03d",order)+" "+scriptName);
    migration.setExecutor(new SqlMigrationExecutor(database,
            new FileSystemResource(migration.getScript(), configuration.getEncoding()),
            new PlaceholderReplacer() {

                @Override
                public String replacePlaceholders(String input) {

                    // just remove parts of the sql that flyway can't deal with
                    input = StringUtils.replace(input, "WHENEVER SQLERROR EXIT SQL.SQLCODE ROLLBACK;", "");
                    input = StringUtils.replace(input, "SET DEFINE OFF;", "");

                    return input;
                }

                @Override
                public Map<String, String> getPlaceholderReplacements() {
                    return null;
                }
            }
            , configuration));
    return migration;
}