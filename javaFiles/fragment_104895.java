public class EventSelectedListener implements AdapterView.OnItemClickListener {

    private Activity mActivity;

    public EventSelectedListener(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
         Intent intent = new Intent();             
         intent.setClass(mActivity, MediaPlayerActivity.class);
         mActivity.startActivity(intent);       
    }
}