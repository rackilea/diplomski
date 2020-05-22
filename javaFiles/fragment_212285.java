public class MainActivity extends AppCompatActivity implements FragCallback{
...
 FloatingActionButton fab_filter = (FloatingActionButton) findViewById(R.id.fab_filter);
fab_filter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      DialogFrag.newInstance(this).show(getFragmentManager(),FragDialog.class.getSimpleName());
    }
}
....
@Override
public void filter(String max, String min){
    //do the filtering
}