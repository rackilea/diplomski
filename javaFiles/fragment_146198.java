import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    Type currencyDataMapType = new TypeToken<Map<String, CurrencyData>>() {}.getType();
    Map<String, CurrencyData> currencyDataMap = gson.fromJson(new FileReader("input.json"), currencyDataMapType);
    List<Currency> currencies = fromDataMap(currencyDataMap);
    System.out.println(currencies);
  }

  static List<Currency> fromDataMap(Map<String, CurrencyData> currencyDataMap)
  {
    List<Currency> currencies = new ArrayList<Currency>(currencyDataMap.size());
    for (Entry<String, CurrencyData> entry : currencyDataMap.entrySet())
    {
      String code = entry.getKey();
      currencies.add(new Currency(code, currencyDataMap.get(code)));
    }
    return currencies;
  }
}

class Currency
{
  String code;
  CurrencyData data;

  Currency(String code, CurrencyData data)
  {
    this.code = code;
    this.data = data;
  }

  @Override
  public String toString()
  {
    return String.format("{code:%s, 7d:%s, 30d:%s, 24h:%s}", code, data._7d, data._30d, data._24h);
  }
}

class CurrencyData
{
  @SerializedName("7d")
  BigDecimal _7d;
  @SerializedName("30d")
  BigDecimal _30d;
  @SerializedName("24h")
  BigDecimal _24h;
}