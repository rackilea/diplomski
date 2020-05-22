public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}

public interface RoleRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);

    @Override
    void delete(Authority role);

}

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String username);

    @Override
    void delete(User user);
}