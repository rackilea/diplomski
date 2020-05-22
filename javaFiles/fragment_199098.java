@Query("SELECT e FROM Entity e WHERE (e.created < ?#{@yourRepo.secondsBefore(#timeout))}")
List<Entity> findOldEntries(@Param("timeout") int timeout);

// add a method that returns an Instant that matches your time
default Instant secondsBefore(int seconds) {
    return Instant.now().minus(seconds, ChronoUnit.SECONDS);
}