void runSql(String sql, String modelName) {

    Class modelClass = Class.forName("com.mycompany.model." + modelName);

    List<?> models = JdbcTemplate.queryForList(sql, modelClass, params);

    for (Object model : models) { 
        //Then you should cast your model manually if you need to
        if (model instanceof MyModel) {
            MyModel myModel = (MyModel) model;
            //do whatever with object of MyModel class
        }
    }
}