import com.google.gson.Gson;

public class TestGSON 
{
    public static void main( String[] args )
    {
        // that's your JSON sample
        String json = "[{\"reserve_no\":\"20\",\"city\":\"city2\",\"street\":\"street1234\",\"discription\":\"discription123\",\"date\":\"2012-10-22 04:47:54\",\"customer\":\"abc\"}]";
        // note: we tell Gson to expect an **array** of Data
        Data data[] = new Gson().fromJson(json, Data[].class);
        System.out.println(data[0]);
    }
}