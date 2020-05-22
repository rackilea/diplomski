import com.google.gson.Gson;

public class GsonFoo
{
  public static void main(String[] args)
  {
    MyBean bean = new MyBean();
    bean.data = "some data";
    bean.problem = new RuntimeException("Ack!");

    System.out.println(new Gson().toJson(bean));
  }
}

class MyBean
{
  public String data;
  public Exception problem;
}