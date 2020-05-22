public class ComplainMasterDaoImpl implements ComplainMasterDao
{

@Override
public ComplainMaster fetchComplainInfo(String orderId, String user) throws Exception
{
    // TODO Auto-generated method stub
    HttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost("http://localhost:8383/alfresco/service/get-order-    info");

    String basic_auth = new String(Base64.encodeBase64((YOUR_USER_NAME+":"+YOUR_PASSWORD).getBytes()));
    httpPost.addHeader("Authorization", "Basic " + basic_auth);

    List<NameValuePair> formParams = new ArrayList<NameValuePair>();
    formParams.add(new BasicNameValuePair("orderId", orderId));
    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
    httpPost.setEntity(formEntity);
    HttpResponse httpResponse = httpClient.execute(httpPost);
    HttpEntity httpEntity = httpResponse.getEntity();
    String responseString = IOUtils.toString(httpEntity.getContent(), "UTF-8");
    JSONObject jsonObject = (JSONObject) new JSONParser().parse(responseString);
    JSONObject resultJson = (JSONObject) jsonObject.get("result");

    System.out.println(resultJson.toString());
    return null;
}
}