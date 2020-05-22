@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IShareObjectService {

  @WebMethod
  String getTest();
}