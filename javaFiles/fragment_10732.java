private ArrayList<productinfo> AddedItems;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // you have to put this part of code when you show the dialog so that 
    // it will be executed all the time you open the dialog 
    if(AddedItems != null){

        allProducts.addAll(AddedItems);

        AddedItems = null;

    }
    else{

        allProducts = dh.gettAllProductInfo();

    }

    adapter = new ProductListAdapter(getApplicationContext(), allProductss);

    productListView.setAdapter(adapter);

    doneButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            AddedItems = new ArrayList<productinfo>();          

            try
            {

                for(int i = 0;i<allProductss.size();i++)
                {   

                    View view = productListView.getChildAt(i);
                    EditText qty = (EditText) view.findViewById(R.id.quantity_edittext);
                    String qtyVal = qty.getText().toString();
                    TextView product = (TextView) view.findViewById(R.id.product_textview);
                    String pName = product.getText().toString();
                    TextView p_code = (TextView) view.findViewById(R.id.product_code);
                    String pCode = p_code.getText().toString();

                    if(!qty.getText().toString().matches(""))
                    {
                        AddedItems.add(new productinfo(pCode, pName, "", qtyVal, ""));
                    }

                }
            }   
            catch(Exception e){}

        }

    }

}