public class CustomAdapter extends ArrayAdapter<String> {

public ArrayList<String> mlist;
public Context context;
public LayoutInflater inflater;

public CustomAdapter(Context context, int resource, ArrayList<String> mlist) {
    super(context, resource);
    this.mlist = mlist;
    this.context = context;
    inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public int getPosition(Sample item) {
    return super.getPosition(item);
}

@Override
public Sample getItem(int position) {
    return mlist.get(position);
}

@Override
public int getCount() {
    return mlist.size();
}

@Override
public long getItemId(int position) {
    return super.getItemId(position);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    convertView = inflater.inflate(R.layout.listitem, null);
    TextView text1 = (TextView) convertView.findViewById(R.id.item1);       
    text1.setText(mlist.get(position).getListitem1());      
    return convertView;
}