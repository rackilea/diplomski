import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.version=u.version+1, u.active = false WHERE u.id = ?1")
    void deactivate(Long id);

    @Modifying
    @Query("UPDATE User u SET u.version=u.version+1, u.active = false WHERE u.id IN :ids")
    void deactivateAll(@Param("ids") Long... ids);

    @Modifying
    @Query("UPDATE User u SET u.version=u.version+1, u.active = false WHERE u.id IN :ids")
    void deactivateAll(@Param("ids") Iterable<Long> ids);

}