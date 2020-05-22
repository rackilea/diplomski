package b;
import a.IGetResult;

public class InnterTest {
   protected class GetResultImpl implements IGetResult {
       @Override
       String getResult() { return "result"; }
   }

}