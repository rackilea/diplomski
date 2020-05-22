public class Q19201300 {

  public static void main(String[] args) {
      String json = "\"hour_totals\": {  "
              + "  \"382423\": {                 "
              + "  \"imp\": 126,                 "
              + "  \"clk\": 1,                   "
              + "  \"spend\": \"$0.03\",         "
              + "  \"conv\": 0,                  "
              + "  \"cpm\": \"$0.22\",           "
              + "  \"cpc\": \"$0.03\",           "
              + "  \"ctr\": \"0.79%\",           "
              + "  \"cpa\": \"$Inf\"             "
              + "},                              "
              + "\"382424\": {                   "
              + "  \"imp\": 209,                 "
              + "  \"clk\": 1,                   "
              + "  \"spend\": \"$0.05\",         "
              + "  \"conv\": 0,                  "
              + "  \"cpm\": \"$0.23\",           "
              + "  \"cpc\": \"$0.05\",           "
              + "  \"ctr\": \"0.48%\",           "
              + "  \"cpa\": \"$Inf\"             "
              + "}}                              ";

      Total t = new Gson().fromJson("{" + json + "}", Total.class);

      System.out.println(t);

  }
}