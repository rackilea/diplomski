@Service
public class ClientHelloRpcServiceImpl implements ClientHelloRpcService {
  @Override
  public void hello() {
    HttpSession session = RpcContext.getHttpSession();
    System.out.println("Client said hello. Session ID: " + session.getId());
  }
}