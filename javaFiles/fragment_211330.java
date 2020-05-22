public class CustomMenuLVAdapter extends BaseAdapter {
ArrayList<String> resultMenuItems;
LVItemHolder lvItemHolder;
Context context;
private static LayoutInflater inflater = null;

HashMap<Integer, Integer> map = new HashMap<>;

public CustomMenuLVAdapter(LVMenuFragment lvMenuFragment, ArrayList<String> listMenuArray) {
    resultMenuItems = listMenuArray;
    context = lvMenuFragment.getActivity();
    inflater = (LayoutInflater) context.
            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public int getCount() {
    return resultMenuItems.size();
}

@Override
public Object getItem(int position) {
    return position;
}

@Override
public long getItemId(int position) {
    return position;
}

public class LVItemHolder {
    TextView listMenuTV, txtQTY;
    RelativeLayout qtyView;
    Button minusBtn;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    final LVItemHolder lvItemHolder = new LVItemHolder();
    View rowView;
    rowView = inflater.inflate(R.layout.menu_list_item, null);
    lvItemHolder.listMenuTV = (TextView) rowView.findViewById(R.id.menulistTV2);
    lvItemHolder.txtQTY = (TextView) rowView.findViewById(R.id.txtQTY);
    lvItemHolder.minusBtn = (Button) rowView.findViewById(R.id.minusBtn);
    lvItemHolder.listMenuTV.setText(resultMenuItems.get(position));

    if(map.containsKey(position)){
          lvItemHolder.txtQTY.setText(""+map.get(position));
    }else{
        lvItemHolder.txtQTY.setText("0");
     } 

    rowView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int q = 0;
            q = Integer.valueOf(lvItemHolder.txtQTY.getText().toString());
            q++;
            lvItemHolder.txtQTY.setText("" + q);
           map.put(position,q)
           //                Toast.makeText(context, "You Clicked "+resultMenuItems.get(position), Toast.LENGTH_LONG).show();
        }
    });
    lvItemHolder.minusBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int q = 0;
            q = Integer.valueOf(lvItemHolder.txtQTY.getText().toString());
            if (q > 0)
                q--;
            lvItemHolder.txtQTY.setText("" + q);
            map.put(position,q)
        }
    });
    return rowView;
}