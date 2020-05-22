protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main); <<----UNDER THIS (left in for location purpose)

// Add your initialization code here

Parse.initialize(this, "YOUR_APPLICATION_ID", "YOUR_CLIENT_KEY");

ParseUser.enableAutomaticUser();

ParseACL defaultACL = new ParseACL();

// If you would like all objects to be private by default, remove this

// line.

defaultACL.setPublicReadAccess(true);

ParseACL.setDefaultACL(defaultACL, true);

// Determine whether the current user is an anonymous user

if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) { <<----(left in for location purpose)