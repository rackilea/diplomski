public class MyAdapter extends BaseExpandableListAdapter{

    public interface MyAdapterListener{
        public void doRefresh();
    }

    private MyAdapterListener listener;

    public MyAdapter(MyAdapterListener listener){
        this.listener = listener;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {

        if(some condition is true and you want to refresh the list view){
            listener.doRefresh();
        }
        return null;
    }

}