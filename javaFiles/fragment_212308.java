@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Server {
  @JacksonXmlProperty(localName = "serverport")
  private String serverPort;
}