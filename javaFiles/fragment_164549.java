@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
}


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByColumn(String columnName, Object value) {
        return productRepository.find((Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            return builder.and(builder.equal(root.<String>get(columnName), value));
        });
    }
}