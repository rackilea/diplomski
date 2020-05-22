public class ListAdapter extends BaseAdapter {

    public ArrayList<Integer> quantity = new ArrayList<Integer>();
    public ArrayList<Integer> price = new ArrayList<Integer>();
    private String[] listViewItems, prices, static_price;
    TypedArray images;
    View row = null;

    static String get_price, get_quntity;
    int g_quntity, g_price, g_minus;

    private Context context;
    CustomButtonListener customButtonListener;

    static HashMap<String, String> map = new HashMap<>();


    public ListAdapter(Context context, String[] listViewItems, TypedArray images, String[] prices) {
        this.context = context;
        this.listViewItems = listViewItems;
        this.images = images;
        this.prices = prices;

        for (int i = 0; i < listViewItems.length; i++) {
            quantity.add(0);
        }
    }

    public void setCustomButtonListener(CustomButtonListener customButtonListner) {
        this.customButtonListener = customButtonListner;
    }

    @Override
    public int getCount() {
        return listViewItems.length;
    }

    @Override
    public String getItem(int position) {
        return listViewItems[position];
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ListViewHolder listViewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_custom_listview, parent, false);
            listViewHolder = new ListViewHolder();
            listViewHolder.tvProductName = (TextView) row.findViewById(R.id.tvProductName);
            listViewHolder.ivProduct = (ImageView) row.findViewById(R.id.ivproduct);
            listViewHolder.tvPrices = (TextView) row.findViewById(R.id.tvProductPrice);
            listViewHolder.btnPlus = (ImageButton) row.findViewById(R.id.ib_addnew);
            listViewHolder.edTextQuantity = (EditText) row.findViewById(R.id.editTextQuantity);
            listViewHolder.btnMinus = (ImageButton) row.findViewById(R.id.ib_remove);
            static_price = context.getResources().getStringArray(R.array.Price);
            row.setTag(listViewHolder);
        } else {
            row = convertView;
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.ivProduct.setImageResource(images.getResourceId(position, -1));
        listViewHolder.edTextQuantity.setText(quantity.get(position) + "");
        listViewHolder.tvProductName.setText(listViewItems[position]);
        listViewHolder.tvPrices.setText(prices[position]);


        listViewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customButtonListener != null) {
                    customButtonListener.onButtonClickListener(position, listViewHolder.edTextQuantity, 1);

                    quantity.set(position, quantity.get(position) + 1);
                    //price.set(position, price.get(position) + 1);

                    row.getTag(position);

                    get_price = listViewHolder.tvPrices.getText().toString();

                    g_price = Integer.valueOf(static_price[position]);

                    get_quntity = listViewHolder.edTextQuantity.getText().toString();
                    g_quntity = Integer.valueOf(get_quntity);

                    map.put("" + listViewHolder.tvProductName.getText().toString(), " " + listViewHolder.edTextQuantity.getText().toString());
//                    Log.d("A ", "" + a);
//                    Toast.makeText(context, "A" + a, Toast.LENGTH_LONG).show();
//                    Log.d("Position ", "" + position);
//                    System.out.println(+position + " Values " + map.values());
                    listViewHolder.tvPrices.getTag();
                    listViewHolder.tvPrices.setText("" + g_price * g_quntity);
                    ShowHashMapValue();

                }


            }

        });
        listViewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customButtonListener != null) {

                    customButtonListener.onButtonClickListener(position, listViewHolder.edTextQuantity, -1);
                    if (quantity.get(position) > 0)
                        quantity.set(position, quantity.get(position) - 1);

                    get_price = listViewHolder.tvPrices.getText().toString();
                    g_minus = Integer.valueOf(get_price);
                    g_price = Integer.valueOf(static_price[position]);
                    int minus = g_minus - g_price;
                    if (minus >= g_price) {
                        listViewHolder.tvPrices.setText("" + minus);
                    }
                    map.put("" + listViewHolder.tvProductName.getText().toString(), " " + listViewHolder.edTextQuantity.getText().toString());
                    ShowHashMapValue();
                }
            }
        });


        return row;
    }

    private void ShowHashMapValue() {
        /**
         * get the Set Of keys from HashMap
         */
        Set setOfKeys = map.keySet();

/**
 * get the Iterator instance from Set
 */
        Iterator iterator = setOfKeys.iterator();

/**
 * Loop the iterator until we reach the last element of the HashMap
 */
        while (iterator.hasNext()) {
/**
 * next() method returns the next key from Iterator instance.
 * return type of next() method is Object so we need to do DownCasting to String
 */
            String key = (String) iterator.next();

/**
 * once we know the 'key', we can get the value from the HashMap
 * by calling get() method
 */
            String value = map.get(key);

            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}