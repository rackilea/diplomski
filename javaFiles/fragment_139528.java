@Repository
@Slf4j
@RequiredArgsConstructor
public class FieldRepository {

    private final DSLContext dsl;

    private final DataSource dataSource;

    //... dsl and datasource are correctly injected 

}