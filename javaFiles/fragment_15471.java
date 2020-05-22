import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(Integration.class)
@Suite.SuiteClasses ({AllTestsSuite.class} )
public class IntegrationTestSuite {}