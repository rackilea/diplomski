private ProgressDialog pDialog;


// URL to get contacts JSON
private static String url = "http://api.androidhive.info/contacts/";

// JSON Node names
private static final String TAG_CONTACTS = "contacts";
private static final String TAG_ID = "id";
private static final String TAG_NAME = "name";
private static final String TAG_EMAIL = "email";
private static final String TAG_ADDRESS = "address";
private static final String TAG_GENDER = "gender";
private static final String TAG_PHONE = "phone";
private static final String TAG_PHONE_MOBILE = "mobile";
private static final String TAG_PHONE_HOME = "home";
private static final String TAG_PHONE_OFFICE = "office";


private boolean isConnection = false;

// contacts JSONArray
JSONArray contacts = null;

// Hashmap for ListView
ArrayList<HashMap<String, String>> contactList;

ArrayList<HashMap<String, String>> oflineContactList;

private MyContactDataSource dataSource;

List<Contatcs> oflineContatcs;