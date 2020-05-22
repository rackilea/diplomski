@Service
@Log4j2
@CacheConfig(keyGenerator = "customKeyGenerator")
class CustomerService {

    @Cacheable(value = "customers", unless = "@monitoring.monitoringUser()")
    public Customer getLoggedInCustomer() {
        return repository.getLoggedInCustomer; // slow 
    }

}