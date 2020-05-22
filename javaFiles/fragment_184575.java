package c;
import a.IGetResult;
import b.InnterTest;

public class InnerTestSubclass extends InnerTest {

   public IGetResult getResultClass() {
      //Up-casting happens automatically since GetResultImpl is sub-class of IGetResult
      return new GetResultImpl();
   }
}