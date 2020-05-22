import org.json.JSONException;
import org.json.JSONObject;

public class TestCode {

    private final static String JSON_TEST_DATA
    = "{"
    + "   \"tms_guid\": \"9LaHmoHpmTd811R\", "
    + "   \"recharge_status\": \"100\", "
    + "   \"message\": \"Transaction Successful\", "
    + "   \"response_time\": { "
    + "      \"verifyClient\": 0.0281, "
    + "      \"verifyGuid\": 0.8695, "
    + "      \"verifyOperator\": 0.8698,"
    + "      \"verifyMsid\": 0.8698,"
    + "      \"tms_guid\": 1.6971,"
    + "      \"queryErr\": 7.4243,"
    + "      \"StoringRecharge\": 7.4358,"
    + "      \"UpdatingBalance\": 7.448"
    + "   }"
    + "}";

    public static void main (String arg[]) throws JSONException{

        //System.out.println(JSON_TEST_DATA);
        final JSONObject testObj = new JSONObject(JSON_TEST_DATA);

        System.out.println(" --"+testObj.getString("recharge_status")+"\n");
    System.out.println(testObj.toString());
    }

}