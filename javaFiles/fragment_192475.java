static String userName;
static String password;
static String newUserNames[];
static String newUserPasswords[];
static String newUserConfirmPasswords[];
static String newUserFirstNames[];
static String newUserLastNames[];
static String userGroup[];
Public static void readFile() {
JSONParser parser = new JSONParser();
try {
Object obj = parser.parse(new FileReader("<<Location of ur input json data file>>"));
jsonObject = (JSONObject) obj;
/**
* This section is to read login data from input json file.
*/
JSONObject gveLogin = (JSONObject) jsonObject.get("appLogin");
userName = (String) gveLogin.get("userName");
password = (String) gveLogin.get("password");
/**
* This section is to read create new user from input json file.
*/
JSONObject createNewUser = (JSONObject) jsonObject.get("createNewUser");
JSONArray newUserName = null;
Object newUserNameObj = (createNewUser !=   null &&     
createNewUser.containsKey("UserName")) ? createNewUser.get("UserName") : null;
if (newUserNameObj !=null && newUserNameObj instanceof JSONArray){
newUserName = (JSONArray) newUserNameObj;
}
int newUserNameSize = newUserName.size();
newUserNames = new String[newUserNameSize];
int newUserNameCount;
for (newUserNameCount = 0;newUserNameCount<newUserNameSize; newUserNameCount++){
newUserNames [newUserNameCount] = (String) newUserName.get(newUserNameCount);
System.out.println(newUserNames[newUserNameCount]);
}
.... Same for password, confirm password, first name , last name and for userGroup I have used jsonObject as follows:
newUserGroup = (String) createNewUser.get("userGroup");