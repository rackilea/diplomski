ServerConfig saetrServerConfig = new ServerConfig();
saetrServerConfig.setName("distantdatabase");
saetrServerConfig.setDdlGenerate(false); // ddlGenerate drops all tables and create new tables
saetrServerConfig.setDdlRun(false); // ddlRun run migration scripts
saetrServerConfig.setDefaultServer(false);
saetrServerConfig.setRegister(true);
saetrServerConfig.setDataSourceConfig(ds);
saetrServerConfig.setClasses(saetrClasses);