MyEntityMapper mapper = session.getMapper(MyEntityMapper.class);
try (Cursor<MyEntity> entities = mapper.getEntities()) {
   for (MyEntity entity:entities) {
      // process one entity
   }
}