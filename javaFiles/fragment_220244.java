@Select({
      "SELECT *",
      "FROM my_entity",
      "ORDER BY id"
})
Cursor<MyEntity> getEntities();