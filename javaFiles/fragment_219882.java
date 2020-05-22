public class MainActivity extends Activity implements IExpandableListInterface{

        public void onClickIconaModifica(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
             // do your stuff here
              Toast.makeText(MainActivity.this, "Group position: "+groupPosition, Toast.LENGTH_LONG).show();


        }
   }