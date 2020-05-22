public class com.myapp.server.DefaultAdditionService {
  // The server-side AdditionRequest type.
  public Integer sum(AdditionRequest request) {
    Integer sum = request.getAddend() + request.getAugend();
    return sum;
  }
}