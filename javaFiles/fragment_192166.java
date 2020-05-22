public class CustomMenuListViewAdapter extends ArrayAdapter<MenuListItem> {
    Context context;
    int layoutResourceId;
    ArrayList<MenuListItem> dataListMenu = new ArrayList<MenuListItem>();
        RecordListMenuHolder recordListMenuHolder;
int qty = 0;

    public CustomMenuListViewAdapter(Context context, int layoutResourceId, ArrayList<MenuListItem>dataListMenu) {
        super(context,layoutResourceId,dataListMenu);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.dataListMenu = dataListMenu;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listMenuRow = convertView;

        if(listMenuRow == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            listMenuRow = inflater.inflate(layoutResourceId, parent, false);

            recordListMenuHolder = new RecordListMenuHolder();
//            recordListMenuHolder.menuItemImage = (String) listMenuRow.findViewById(R.id.itemImage);
            recordListMenuHolder.listMenuTV = (TextView) listMenuRow.findViewById(R.id.menulistTV2);
            recordListMenuHolder.qtyView = (RelativeLayout) listMenuRow.findViewById(R.id.qtyID);
            recordListMenuHolder.minusBtn = (Button) listMenuRow.findViewById(R.id.minusBtn);
            listMenuRow.setTag(recordListMenuHolder);
        }else{
            recordListMenuHolder = (RecordListMenuHolder)listMenuRow.getTag();
        }

        MenuListItem menuListItem = dataListMenu.get(position);
        recordListMenuHolder.listMenuTV.setText(menuListItem.getMenuItemName());
listMenuRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
qty++;

recordListMenuHolder.qtyView.setText(""+qty);
            }
        });

        return listMenuRow;
    }

    static class RecordListMenuHolder {
//        Image menuItemImage;
        TextView listMenuTV;
        RelativeLayout qtyView;
        Button minusBtn;
        Button plusBtn;
    }
}