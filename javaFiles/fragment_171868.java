Map<String, String> env = System.getenv();
Map<String, Object> configOverrides = new HashMap<String, Object>();
for (String envName : env.keySet()) {
  if (envName.contains("JDBC_DATABASE_URL")) {
    configOverrides.put("javax.persistence.jdbc.url", env.get(envName));
  }
}
entityManagerFactory = Persistence.createEntityManagerFactory("prod", configOverrides);