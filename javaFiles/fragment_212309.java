@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JacksonXmlRootElement(localName = "config")
public class Config {

  private Server server;
  private Client client;
}