public abstract class MyActivityWithListener extends Activity 
        implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
        ....
    }

}