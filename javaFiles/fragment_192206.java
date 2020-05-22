@Query("SELECT g FROM Game g" +
    " WHERE (:title is null or g.title = :title)" +
    " AND (:type is null or g.type = :type)" +
    " AND (:locations is null or g.locations in :locations)")
Long<Game> findByGameTitleOrGameTypeOrGameLocations(
    @Param("title") String title,
    @Param("type") String type,
    @Param("locations") Set<String> locations);