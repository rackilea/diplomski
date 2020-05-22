public class CustomerDetail implements Response<XYZ, PQR> {
  @Override
  public void response(XYZ data, PQR... args) {
    PQR request = args[0];
    Map reportMap = data.any();
    //do something
  }
}