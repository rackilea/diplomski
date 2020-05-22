import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SkillRatingRepository extends Neo4jRepository<SkillRating, Long> {

    @Query("MATCH (p)-[r:RATED]->(skill) WHERE id(p) = :#{#person.id} RETURN p, r, skill")
    List<SkillRating> findAllByPerson(Person person);
}