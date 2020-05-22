@Entity
@Indexed
@AnalyzerDef(
    name = "myCollationAnalyzer",
    filters = {
        @TokenFilterDef(
            name = "polish_collation",
            factory = ElasticsearchTokenFilterFactory.class,
            params = {
                @Parameter(name = "type", value = "'icu_collation'"),
                @Parameter(name = "language", value = "'pl'")
            }
        )
    }
)
public class MyEntity {