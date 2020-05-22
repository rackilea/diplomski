@Configuration
public class PathServerKeycloakConfigResolver implements KeycloakConfigResolver
{
  @Override
  public KeycloakDeployment resolve(Request request)
  {
    String hostname = "Unknown";

    try
    {
      InetAddress addr;
      addr = InetAddress.getLocalHost();
      hostname = addr.getHostName();
      return KeycloakDeploymentBuilder.build(getKeycloakJson(hostname));
    }
    catch (IOException e)
    {
      e.printStackTrace();
      return null;
    }
  }

  private InputStream getKeycloakJson(String hostname) throws IOException
  {
    InputStream inputStream = new FileInputStream("src/main/resources/keycloak.json");
    InputStreamReader isReader = new InputStreamReader(inputStream);
    BufferedReader reader = new BufferedReader(isReader);
    StringBuffer sb = new StringBuffer();
    String str;
    while ((str = reader.readLine()) != null)
    {
      sb.append(str);
    }

    return new ByteArrayInputStream(sb.toString().replace("{param_keycloak_server}", hostname).getBytes(StandardCharsets.UTF_8));
  }


}