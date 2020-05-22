MATCH (p:Publication) WHERE p.name=~ ('(?i)' + {0} + '.*') RETURN p

public interface PublicationRepo extends GraphRepository<Publication> {
    Publication findByName(String name);
    @Query("MATCH (p:Publication) WHERE p.name=~ ('(?i)'+{0}+'.*') RETURN p")
    Iterable<Publication> findByNameLikeIgnoreCase(String name);
}