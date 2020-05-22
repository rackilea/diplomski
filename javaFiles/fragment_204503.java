CassandraTemplate template = …

Person person = …

CqlIdentifier tableName = template.getTableName(Person.class);

Insert insert = CassandraTemplate.createInsertQuery(tableName.toCql(), person, 
                    new WriteOptions(), template.getConverter());

Delete delete = CassandraTemplate.createDeleteQuery(tableName.toCql(), person,
                    new WriteOptions(), template.getConverter());

Update update = CassandraTemplate.createUpdateQuery(tableName.toCql(), person, 
                    new WriteOptions(), template.getConverter());