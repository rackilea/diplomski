@Component
public class SystemStateWebSocketBuffer {
  private List<SystemStateWS> systemStateSockets = new ArrayList<>();

  public void add(SystemStateWS systemStateWS) {
    this.systemStateSockets.add(systemStateWS);
  }

  public List<SystemStateWS> getSystemStateSockets() {
    return systemStateSockets;
  }

  public void setSystemStateSockets(List<SystemStateWS> systemStateSockets) {
    this.systemStateSockets = systemStateSockets;
  } 

}