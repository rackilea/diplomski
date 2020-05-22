public class SendVerifySubjectProcessor implements SubjectProcessor
{
   @Override
   public void process(JSONObject data) {
     String foo1 = data.getString("foo1_1");
     String foo2 = data.getString("foo1_2");
     ...
   }
}