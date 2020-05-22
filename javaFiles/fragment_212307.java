@Getter
@NoArgsConstructor
@Setter
public class Client {

  @JacksonXmlProperty(localName = "clientport")
  private String clientPort;
  @JacksonXmlProperty(localName = "serverHost")
  private String serverHost;

}