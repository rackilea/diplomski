public class ExpandableListAdapter extends BaseExpandableListAdapter {

static int count=0;
private Context _context;

HashMap<String,Food> selectedItems;

public List<String> listDataHeader; // header titles

// child data in format of header title, child title
public HashMap<String, ArrayList<Food>> _listDataChild;

CheckOutItems checkOutItems;

public ExpandableListAdapter(Context context, List<String> listDataHeader,
                             HashMap<String, ArrayList<Food>> listChildData) {
    this._context = context;
    this.listDataHeader = listDataHeader;
    this._listDataChild = listChildData;

    selectedItems = new HashMap<>();

    checkOutItems = (CheckOutItems)context;

}

@Override
public Food getChild(int groupPosition, int childPosititon) {
    return this._listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosititon);
}

@Override
public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
}

Button button;
@Override
public View getChildView(final int groupPosition, final int childPosition,
                         boolean isLastChild, View convertView, ViewGroup parent) {

    View row;
    final ListViewHolder listViewHolder;
    if(convertView == null)
    {
        LayoutInflater layoutInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = layoutInflater.inflate(R.layout.list_item,parent,false);

        listViewHolder = new ListViewHolder();
        listViewHolder.foodName = row.findViewById(R.id.lblListItem);
        listViewHolder.foodPrice = row.findViewById(R.id.lblListItem1);
        listViewHolder.cartQuantity = row.findViewById(R.id.integer_number);
        listViewHolder.increment = row.findViewById(R.id.increase);
        listViewHolder.decrement = row.findViewById(R.id.decrease);
        listViewHolder.addButton = row.findViewById(R.id.addbtn);
        row.setTag(listViewHolder);
    }
    else
    {
        row=convertView;
        listViewHolder= (ListViewHolder) row.getTag();
    }
    final Food food=getChild(groupPosition,childPosition);

    listViewHolder.foodName.setText(food.Foodname);
    listViewHolder.foodPrice.setText(food.FoodPrice+" $");
    listViewHolder.cartQuantity.setText(food.CartQuantity+"");
    listViewHolder.increment.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            updateQuantity(groupPosition,childPosition,listViewHolder.cartQuantity,1);
        }
    });
    //listViewHolder.edTextQuantity.setText("0");
    listViewHolder.decrement.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateQuantity(groupPosition,childPosition,listViewHolder.cartQuantity,-1);

        }
    });

    listViewHolder.addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedItems.put(food.Foodname,food);
            checkOutItems.sendItems(selectedItems);
        }
    });

    return row;
}

private void updateQuantity(int group,int position, TextView edTextQuantity, int value) {

    Food food = getChild(group,position);
    if(value > 0&&food.CartQuantity<10)
    {
        food.CartQuantity = food.CartQuantity + 1;
        count++;


    }
    else
    {
        if(food.CartQuantity > 0)
        {
            food.CartQuantity = food.CartQuantity - 1;
            count--;

        }

    }
    edTextQuantity.setText(food.CartQuantity+"");
}


@Override
public int getChildrenCount(int groupPosition) {
    return _listDataChild.get(listDataHeader.get(groupPosition))
            .size();
}

@Override
public Object getGroup(int groupPosition) {
    return this.listDataHeader.get(groupPosition);
}

@Override
public int getGroupCount() {
    return this.listDataHeader.size();
}

@Override
public long getGroupId(int groupPosition) {
    return groupPosition;
}

@Override
public View getGroupView(int groupPosition, boolean isExpanded,
                         View convertView, ViewGroup parent) {
    String headerTitle = (String) getGroup(groupPosition);
    if (convertView == null) {
        LayoutInflater infalInflater = (LayoutInflater) this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = infalInflater.inflate(R.layout.list_group, null);
    }

    TextView lblListHeader = (TextView) convertView
            .findViewById(R.id.lblListHeader);
    lblListHeader.setTypeface(null, Typeface.BOLD);
    lblListHeader.setText(headerTitle);

    return convertView;
}

@Override
public boolean hasStableIds() {
    return false;
}

@Override
public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
}

interface CheckOutItems
{
    public void sendItems(HashMap<String,Food> selectedItems);
}
 }