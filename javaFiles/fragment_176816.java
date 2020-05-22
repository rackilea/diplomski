public interface UserRepository extends JpaRepository<User, Long> {

   User findByUsername(String username);

   List<User> findByStructureAndSiteAndValid(Structure structure, Site site, boolean valid);
}