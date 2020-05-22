import static org.codelibs.elasticsearch.runner.ElasticsearchClusterRunner.newConfigs;
import java.util.Map;
import junit.framework.TestCase;
import org.codelibs.elasticsearch.runner.ElasticsearchClusterRunner;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.bytes.BytesArray;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.ImmutableSettings.Builder;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.get.GetField;
import org.junit.Assert;
import org.elasticsearch.action.search.SearchResponse;
import static org.hamcrest.core.Is.is;

public class CustomParserPluginTest extends TestCase {

    private ElasticsearchClusterRunner runner;

    @Override
    protected void setUp() throws Exception {
        // create runner instance
        runner = new ElasticsearchClusterRunner();
        // create ES nodes
        runner.onBuild(new ElasticsearchClusterRunner.Builder() {
            @Override
            public void build(final int number, final Builder settingsBuilder) {
            }
        }).build(newConfigs().ramIndexStore().numOfNode(1));

        // wait for yellow status
        runner.ensureYellow();
    }

    @Override
    protected void tearDown() throws Exception {
        // close runner
        runner.close();
        // delete all files
        runner.clean();
    }

    public void test_jsonParsing() throws Exception {
        final String index = "test_index";

        runner.createIndex(index, ImmutableSettings.builder().build());
        runner.ensureYellow(index);

        final SearchResponse test = runner.client().prepareSearch(index).setSource(addQuery()).execute().actionGet();
    }

    private String addQuery() {
        return "{\"match_all\":{\"boost\":1.2}}";
    }
}