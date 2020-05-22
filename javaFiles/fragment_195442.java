Configuration conf = BigtableConfiguration.configure("projectId", "instanceId");
conf.set(BigtableOptionsFactory.BIGTABLE_EMULATOR_HOST_KEY, "localhost:8086");
Connection connection = BigtableConfiguration.connect(conf);
Admin admin = connection.getAdmin();
CitizenDAO citizenDao = new CitizenDAO(connection);
String rowKey = citizenDao.persist(new Citizen("IND", 1, "Suhaib", (short) 5, 15, 155L));
Citizen citizen = citizenDao.get("IND|1");
System.out.println(citizen.getName());