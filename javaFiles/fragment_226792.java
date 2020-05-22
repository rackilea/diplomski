MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
// item class map
mapperFactory.classMap(ToDoItemEntity.class, ToDoItemDTO.class)
    .constrcutorB("id", "description", "status")
    .byDefault()
    .register();

mapperFactory.classMap(ToDoTaskListEntity.class, ToDoTaskListDTO.class)
    .constructorB("listName", "toDoItems")
    .byDefault()
    .register();