import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    Type currencyMapType = new TypeToken<Map<String, Currency>>() {}.getType();
    Map<String, Currency> currencyMap = gson.fromJson(new FileReader("input.json"), currencyMapType);
    System.out.println(currencyMap);
  }
}

class Currency
{
  @SerializedName("7d")
  BigDecimal _7d;
  @SerializedName("30d")
  BigDecimal _30d;
  @SerializedName("24h")
  BigDecimal _24h;

  @Override
  public String toString()
  {
    return String.format("{7d:%s, 30d:%s, 24h:%s}", _7d, _30d, _24h);
  }
}