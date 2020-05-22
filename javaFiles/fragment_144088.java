@Autowired 
    EntityManager entityManager;    

    public List<SensorRecord> findSensorDataForDate(LocalDate date) {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
           String tableName = "data_" + date.format(formatter);

           Query query = entityManager.createNativeQuery(
                             "select t.first_column, t.second_column from " + tableName + " t");

           List<Object[]> queryResults = query.getResultList();

           List<SensorRecord> sensorRecords = new ArrayList<>();
           for (Object[] row : queryResults) {
               SensorRecord record = new SensorRecord();
               record.setFirstParameter((Integer) row[0]);
               record.setSecondParameter((String) row[1]);

               sensorRecords.add(record);
           }

           return sensorRecords;
   }