public class ListAdapter extends ArrayAdapter<ListItem> {
private ArrayList<ListItem> listItems;
private Context context;

public ListAdapter(Context context, int textViewResourceId,
    ArrayList<ListItem> listItems) {
super(context, textViewResourceId, listItems);
this.listItems = listItems;
this.context = context;
}

@Override
@SuppressWarnings("deprecation")
public View getView(int position, View convertView, ViewGroup parent) {
ListViewHolder holder = null;
ListItem listItem = listItems.get(position);

if (convertView == null) {
    LayoutInflater vi = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView = vi.inflate(R.layout.list_item, null);

    LinearLayout textViewWrap = (LinearLayout) convertView
            .findViewById(R.id.text_wrap);
    TextView text = (TextView) convertView.findViewById(R.id.text);

    holder = new ListViewHolder(textViewWrap, text);
} else
    holder = (ListViewHolder) convertView.getTag();

holder.getTextView().setText(listItem.getText());

LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT,
        listItem.getCurrentHeight());
holder.getTextViewWrap().setLayoutParams(layoutParams);

holder.getTextView().setCompoundDrawablesWithIntrinsicBounds(
        listItem.getDrawable(), 0, 0, 0);

convertView.setTag(holder);

listItem.setHolder(holder);

return convertView;
}

}