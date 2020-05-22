public class HistoryAdapter extends BaseExpandableListAdapter {
private Context context;
private List<HistoryHeader> _listDataHeader;
//private ArrayList<GridItems> _listGridItems;

public HistoryAdapter(Context context, List<HistoryHeader> _listDataHeader) {
    this.context = context;
    this._listDataHeader = _listDataHeader;
    //this._listGridItems = _listGridItems;
}

@Override
public int getGroupCount() {
    return _listDataHeader.size();
}

@Override
public int getChildrenCount(int groupPosition) {
/*Integer size = _listDataHeader.get(groupPosition).getItemList().size();
return size;*/
    return 1;
}

@Override
public HistoryHeader getGroup(int groupPosition) {
    return _listDataHeader.get(groupPosition);
}

@Override
public Object getChild(int groupPosition, int childPosition) {
    return _listDataHeader.get(groupPosition).getItemList().get(childPosition);
}

@Override
public long getGroupId(int groupPosition) {
    return _listDataHeader.get(groupPosition).hashCode();
}

@Override
public long getChildId(int groupPosition, int childPosition) {
    return _listDataHeader.get(groupPosition).getItemList().get(childPosition).hashCode();
}

@Override
public boolean hasStableIds() {
    return true;
}

@Override
public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
    View v = convertView;
    if (v == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.history_list_group, null);
    }
    TextView groupNum = (TextView) v.findViewById(R.id.historyNumber);
    TextView groupDate = (TextView) v.findViewById(R.id.historyDate);
    TextView groupTransType = (TextView) v.findViewById(R.id.historyTransType);
    TextView groupAmount = (TextView) v.findViewById(R.id.historyTotalAmt);

    HistoryHeader header = _listDataHeader.get(groupPosition);

    groupNum.setText(String.valueOf(header.getId()));
    groupDate.setText(header.getDate());
    groupTransType.setText(header.getTransType());
    groupAmount.setText(header.getTotalAmt());

    return v;
}

@Override
public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {
    View v = convertView;

    // As for using grid view, there is only one child, no suitable view for reuse/recycle.
    //if (v == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.history_list_child, null);
    //}

    TextView itemPropCode = (TextView) v.findViewById(R.id.historyPropertyCode);
    TextView itemPropName = (TextView) v.findViewById(R.id.historyPropertyName);
    GridView itemGrid = (GridView) v.findViewById(R.id.historyItemList);

    // Get the child list of this group/header.
    List<GridItems> history_list_child = getGroup(groupPosition).getItemGrid();

    // As for using grid view, onChildClickListener cannot be used. You may need to pass the group/header object
    // to grid view adapter and do onClick inside getView. First try your original way to display data correctly.
    ItemGridAdapter adapter = new ItemGridAdapter(context, history_list_child);
    itemGrid.setAdapter(adapter);

    HistoryDetail detail = _listDataHeader.get(groupPosition).getItemList().get(childPosition);
    itemPropCode.setText(detail.getPropertyCode());
    itemPropName.setText(detail.getPropertyName());

    return v;
}

@Override
public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
}
}