List<DatabaseFieldConfig> fieldConfigs = new ArrayList<>();
DatabaseFieldConfig field1 = new DatabaseFieldConfig("teacherName");
field1.setColumnName("teacher_name");
fieldConfigs.add(field1);
// add others if necessary ...
DatabaseTableConfig<Entity> tableConfig
    = new DatabaseTableConfig<Entity>(Entity.class, fieldConfigs);