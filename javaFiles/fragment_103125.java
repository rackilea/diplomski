public class searchOrgData extends runautomationAPI
{
protected static String searchDataAPIURL;
private static String line="";
private static StringBuffer result;
public void getOrgData() throws Exception{
generateToken get_authenticationKey = new generateToken();
get_authenticationKey.getToken();
Properties prop = new Properties();
InputStream inputStream  = null;
inputStream  = new FileInputStream("config.properties");
prop.load(inputStream );
searchDataAPIURL = prop.getProperty("searchDataAPIURL");

//Create a list of strings here
List<String[]> arrayList = new List<String[]>();
private String[] test1= {"123", "ABC", "USA"};
private String[] test2= {"", "BGD", "UK"};
arrayList.add(test1);
arrayList.add(test2);

for (String[] arr : arrayList)
{
string ID= arr[0]; 
string name= arr[1]; 
string address= arr[2]; 
JSONObject inputParameterList=new JSONObject();
inputParameterList.put("ID", ID));
inputParameterList.put("Name", name);
inputParameterList.put("Address", address);
String jsonData=inputParameterList.toString();
searchOrgData httpPostReq=new searchOrgData();
HttpPost httpPost=httpPostReq.createConnectivity(searchDataAPIURL);
httpPostReq.executeReq( jsonData, httpPost);}
HttpPost createConnectivity(String restUrl){
HttpPost post = new HttpPost(restUrl);
post.setHeader("Content-Type", "application/json"); 
post.setHeader("Accept", "application/json");
post.setHeader("Authorization","Bearer "+ access_key);
return post;
}
} 
}