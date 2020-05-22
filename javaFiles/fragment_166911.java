import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import play.test.FakeApplication;
import static play.test.Helpers.*;

Map<String, Object> additionalConfiguration = new HashMap<String, Object>();
additionalConfiguration.put("customConfigKey", "customConfigValue");
List<String> withoutPlugins = Arrays.asList("test.A", "test.B");
List<String> additionalPlugins = Arrays.asList("test.C");

FakeApplication app = fakeApplication(additionalConfiguration, additionalPlugins, withoutPlugins);