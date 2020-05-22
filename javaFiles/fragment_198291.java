// key for bundle ...
public static final JSON_STRING = "jsonString";

Intent intent = new Intent(A.this, B.class);
Bundle bundle = new Bundle();
bundle.putString(JSON_STRING,json.toString());
intent.putExtras(bundle);
startActivity(intent);