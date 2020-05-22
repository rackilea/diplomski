@Configuration
@ConfigurationProperties("properties")
@Getter
@Setter
public class MyConfig {
  List<String> ymlArray;
}