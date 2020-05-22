public class Request {

  ...

  void accept(RequestProcessor requestProcessor) {
    requestProcessor.visit(this);
  }
}