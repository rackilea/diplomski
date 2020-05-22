public class ExpandableListAdapter extends BaseExpandableListAdapter {

class ViewHolder {
    TextView childText;
    TextView counterText;
    Button addItemButton;
    Button deleteItemButton;
}

class ChildItem{
    String name;
    int quantity;
    ChildItem(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }
}

class Pos{
    int group;
    int child;
    Pos(int group, int child){
        this.group = group;
        this.child = child;
    }
}

private Context context;
private List<String> listDataHeader;
//private HashMap<String, List<String>> listHashMap;
private HashMap<String, List<ChildItem>> listChildMap;

public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
    this.context = context;
    this.listDataHeader = listDataHeader;
    listChildMap = new HashMap<>();
    for(int i=0; i<getGroupCount(); i++){
        List<ChildItem> listTemp = new ArrayList<>();
        for(int j=0; j<listHashMap.get(listDataHeader.get(i)).size(); j++){
            listTemp.add(new ChildItem(listHashMap.get(listDataHeader.get(i)).get(j), 0));
        }
        listChildMap.put(listDataHeader.get(i), listTemp);
    }
}

@Override
public int getGroupCount() {
    return listDataHeader.size();
}

@Override
public int getChildrenCount(int groupPosition) {
    return listChildMap.get(listDataHeader.get(groupPosition)).size();
}

@Override
public String getGroup(int groupPosition) {
    return listDataHeader.get(groupPosition);
}

@Override
public ChildItem getChild(int groupPosition, int childPosition) {
    return listChildMap.get(listDataHeader.get(groupPosition)).get(childPosition);
}

@Override
public long getGroupId(int groupPosition) {
    return groupPosition;
}

@Override
public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
}

@Override
public boolean hasStableIds() {
    return false;
}

@Override
public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
    String headerTitle = getGroup(groupPosition);
    if(convertView == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_group, null);
    }
    TextView listHeader = (TextView) convertView.findViewById(R.id.list_header);
    listHeader.setTypeface(null, Typeface.BOLD);
    listHeader.setText(headerTitle);
    return convertView;
}

@Override
public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if(convertView == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView textListChild = (TextView) convertView.findViewById(R.id.list_item_header);
        TextView itemsCounter = (TextView) convertView.findViewById(R.id.items_counter);
        Button addItemButton = (Button) convertView.findViewById(R.id.plus_btn);
        viewHolder = new ViewHolder();
        viewHolder.childText = textListChild;
        viewHolder.counterText = itemsCounter;
        viewHolder.addItemButton = addItemButton;
    } else {
        viewHolder = (ViewHolder) convertView.getTag();
    }
    ChildItem child = getChild(groupPosition, childPosition);
    viewHolder.childText.setText(child.name);
    viewHolder.counterText.setText("" + child.quantity);
    viewHolder.addItemButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Pos pos = (Pos)v.getTag();
            ChildItem selectedItem = getChild(pos.group, pos.child);
            selectedItem.quantity = selectedItem.quantity + 1;
            notifyDataSetChanged();

            PutOrderDrinks.addOrder(selectedItem.name);
        }
    });
    viewHolder.addItemButton.setTag(new Pos(groupPosition, childPosition));
    convertView.setTag(viewHolder);
    return convertView;
}

@Override
public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
}
}