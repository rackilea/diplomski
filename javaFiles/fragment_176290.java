@Repository
public interface ReactiveUserRepository extends ReactiveCassandraRepository<User, UUID> {

    Mono<User> findByUsername(String username);

    Mono<User> findByEmail(String email);
}