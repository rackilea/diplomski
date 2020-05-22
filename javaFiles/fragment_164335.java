@Repository
public class MyDao {
@Autowired
public MyDao(DataSource dataSource, @PersistenceObjectMapper ObjectMapper objectMapper) {
// constructor code
}