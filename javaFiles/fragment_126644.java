@Component("UserRepositoryRest")
@Primary
@RepositoryRestResource(collectionResourceRel = "users", path = "users", exported = true)
public interface UserRepositoryRest extends UserRepository {

    @PostAuthorize(" principal.getUsername() == returnObject.getUsername() || hasRole('ROLE_ADMIN') ")
    @Override
    User findOne(Long id);

}