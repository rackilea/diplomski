public class Calc extends Activity {
public static final String PREFS_NAME = "MyPrefsFile";

@Override
protected void onCreate(Bundle state){
   super.onCreate(state);
   . . .

   // Restore preferences
   SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
   String My_String = settings.getString("item", "No item availible");
   int my_int = settings.getInt("integerItem", 0);

}

@Override
protected void onStop(){
   super.onStop();

  // We need an Editor object to make preference changes.
  // All objects are from android.context.Context
  SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
  SharedPreferences.Editor editor = settings.edit();
  editor.putString("item", My_item); // the first parameter is the Key, and the second being the variable
  editor.putInt("integerItem" item_number);

  // Commit the edits!
  editor.commit();
}