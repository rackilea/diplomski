public class TestController extends Controller {

  public Result test(){

    UserMaster UserMaster = UserMaster.find.byId(1L);

    return ok(test.render(teststring));

  }
}