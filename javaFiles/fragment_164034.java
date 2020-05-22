public class ServiceImpl {
  finalStatus = entity.getFinalStatus(this::handleStatus);

  public int handleStatus() {
    return dao.getStatus();
  }
}