public class SpecialRequest extends Request {

  ...

  @Override
  void accept(RequestProcessor requestProcessor) {
    requestProcessor.visit(this);
  }
}