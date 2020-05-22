public class ExpandableListAdapterDrinks extends BaseExpandableListAdapter {

private Context context;
private List<Drink> drinksList;

private Button btReset, btOk;
private List<Integer> groupSum;
private List<List<Integer>> qty;
private int totalSum = 0;

class ViewHolder {
    TextView childText,counterText, childUnitPrice, childFinalPrice;
    Button btn_plus,btn_minus;
}

class Pos{
    int group;
    int child;
    Pos(int group, int child){
        this.group = group;
        this.child = child;
    }
}

public ExpandableListAdapterDrinks(Context context, List<Drink> drinksList,
                                   Button btReset, Button btOk) {
    this.context = context;
    this.drinksList= drinksList;
    this.btReset = btReset;
    this.btOk = btOk;

    groupSum = new ArrayList<>();
    qty = new ArrayList<>();
    for(int i=0; i<drinksList.size(); i++) {
        groupSum.add(0);
        List<Integer> orderedQty = new ArrayList<>();
        for(int j=0; j<drinksList.get(i).getContent().size(); j++) orderedQty.add(0);
        qty.add(orderedQty);
    }
}

private void resetGroupSum(int groupPosition) {
    totalSum -= groupSum.get(groupPosition);
    groupSum.set(groupPosition, 0);
    resetGroupChildrenQty(groupPosition);
}

private void resetGroupChildrenQty(int groupPosition) {
    for(int i=0; i<qty.get(groupPosition).size(); i++) qty.get(groupPosition).set(i, 0);
}

@Override
public int getGroupCount() {
    return drinksList.size();
}

@Override
public int getChildrenCount(int groupPosition) {
    return drinksList.get(groupPosition).getContent().size();
}

@Override
public Drink getGroup(int groupPosition) {
    return drinksList.get(groupPosition);
}

@Override
public String getChild(int groupPosition, int childPosition) {
    return drinksList.get(groupPosition).getContent().get(childPosition);
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
public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
    String headerTitle = drinksList.get(groupPosition).getTitle();

    /** HEADER TEXT HERE */
    if(view==null) {
        LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.vip_package_listgroup,null);
    }
    LinearLayout bgcolor = view.findViewById(R.id.lblListHeaderLayout);
    TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
    TextView lblListHeaderPrice = (TextView)view.findViewById(R.id.lblListHeader_Price);
    Button lblListHeaderButton = view.findViewById(R.id.lblListHeaderButton);

    if(groupSum.get(groupPosition) > 0){
        lblListHeaderPrice.setVisibility(View.VISIBLE);
        lblListHeaderPrice.setText(String.format("%.02f", (float)groupSum.get(groupPosition)).replace(".", ",") + "€");
    }else{
        lblListHeaderPrice.setVisibility(View.GONE);
        lblListHeaderButton.setVisibility(View.GONE);
    }

    if(!drinksList.get(groupPosition).getBg().get(0).isEmpty() || !drinksList.get(groupPosition).getBg().get(1).isEmpty() ) {
        List<String> colorGradientTopBottom = drinksList.get(groupPosition).getBg();
        int[] colors = {Color.parseColor(colorGradientTopBottom.get(0)),Color.parseColor(colorGradientTopBottom.get(1))};
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(0f);
        bgcolor.setBackground(gd);
    } else {
        //bgcolor.setBackgroundColor(ContextCompat.getColor(context, R.color.cardview_bg));
    }
    lblListHeader.setText(headerTitle);

    return view;
}

@Override
public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

    /** Drinks List */
    ViewHolder viewHolder;

    String childDrink = getChild(groupPosition, childPosition);
    int childPrice = getGroup(groupPosition).getPricelist().get(childPosition);

    if (view == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.vip_drinks_listitem, null);

        viewHolder = new ViewHolder();
        viewHolder.childText = view.findViewById(R.id.lblListItemDrinks);
        viewHolder.childUnitPrice = view.findViewById(R.id.lblListItemDrinksUnitPrice);
        viewHolder.counterText = view.findViewById(R.id.vip_drinks_amount);
        viewHolder.childFinalPrice = view.findViewById(R.id.lblListItemDrinksFinalPrice);
        viewHolder.btn_plus = view.findViewById(R.id.vip_drinks_btn_plus);
        viewHolder.btn_minus = view.findViewById(R.id.vip_drinks_btn_minus);

        viewHolder.btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pos pos = (Pos) v.getTag();
                int orderedQty = qty.get(pos.group).get(pos.child);
                orderedQty++;
                qty.get((pos.group)).set(pos.child, orderedQty);
                groupSum.set(pos.group, groupSum.get(pos.group) + getGroup(pos.group).getPricelist().get(pos.child));
                notifyDataSetChanged();
                totalSum += getGroup(pos.group).getPricelist().get(pos.child);
                btOk.setText(String.format("%.02f", (float)totalSum).replace(".", ",") + "€");
                btReset.setEnabled(true);
            }
        });

        viewHolder.btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pos pos = (Pos) v.getTag();
                int orderedQty = qty.get(pos.group).get(pos.child);
                if (orderedQty > 0) {
                    orderedQty--;
                    qty.get((pos.group)).set(pos.child, orderedQty);
                    groupSum.set(pos.group, groupSum.get(pos.group) - getGroup(pos.group).getPricelist().get(pos.child));
                    notifyDataSetChanged();
                    totalSum -= getGroup(pos.group).getPricelist().get(pos.child);
                    if (totalSum == 0) resetTotalSum();
                    else btOk.setText(String.format("%.02f", (float)totalSum).replace(".", ",") + "€");
                }
            }
        });
    } else {
        viewHolder = (ViewHolder) view.getTag();
    }

    viewHolder.childText.setText(childDrink);
    viewHolder.childUnitPrice.setText(String.format("%.02f", (float)childPrice).replace(".", ",") + "€");
    int orderedQty = qty.get(groupPosition).get(childPosition);
    viewHolder.counterText.setText(String.valueOf(orderedQty));
    viewHolder.childFinalPrice.setText(String.format("%.02f", (float)orderedQty*childPrice).replace(".", ",") + "€");

    viewHolder.btn_minus.setTag(new Pos(groupPosition, childPosition));
    viewHolder.btn_plus.setTag(new Pos(groupPosition, childPosition));
    view.setTag(viewHolder);
    return view;
}

@Override
public boolean isChildSelectable(int i, int i1) {
    return false;
}

public void resetTotalSum() {
    for(int i=0; i<drinksList.size(); i++) {
        resetGroupSum(i);
    }
    notifyDataSetChanged();
    btReset.setEnabled(false);
    btOk.setText(String.valueOf(0));
}

public ArrayList<SelectedDrink> getOrderList() {
    ArrayList<SelectedDrink> orderList = new ArrayList<>();
    for(int i=0; i<drinksList.size(); i++) {
        for(int j=0; j<drinksList.get(i).getContent().size(); j++) {
            if(qty.get(i).get(j) > 0) {
                SelectedDrink selectedDrink = new SelectedDrink();
                selectedDrink.content = getGroup(i).getContent().get(j);
                selectedDrink.qty = qty.get(i).get(j);
                orderList.add(selectedDrink);
            }
        }
    }
    return orderList;
}
}