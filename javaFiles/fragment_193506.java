public class Prefs extends PreferenceActivity{

 @Override
 public void onCreate(Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.xml.preferences);
 }
}