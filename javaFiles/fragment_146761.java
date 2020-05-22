MyAdapter.java

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 18-11-2015.
 */
public class MyAdapter extends ArrayAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<MyItem> myItems;

    public MyAdapter(Context context, int resource, ArrayList<MyItem> myItems) {
        super(context, resource, myItems);
        layoutInflater = LayoutInflater.from(context);
        this.myItems = myItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.my_single_item, parent, false);
        TextView name = (TextView) view.findViewById(R.id.text_first);
        TextView something = (TextView) view.findViewById(R.id.text_second);
        MyItem myItem = myItems.get(position);
        name.setText("" + myItem.getName());
        something.setText("" + myItem.getSomething());
        return view;
    }
}