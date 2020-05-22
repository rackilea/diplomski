@Override
public void afterTextChanged(Editable s) {}
@Override
public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
    searchTextLength = searchEditText.getText().length();
    m_orders.clear();
    m_orders = new ArrayList<SearchData>();
    //SearchData o1 = new SearchData();
    SearchData o[]=new SearchData[search_list.length];
    for(int i=0; i<search_list.length; i++)
    {
        if(searchTextLength <= search_list[i].length())
        {
            if(searchEditText.getText().toString().equalsIgnoreCase((String) search_list[i].subSequence(0, searchTextLength)))
            {
                o[i]=new SearchData();
                o[i].setTitleName(search_list[i]);
                o[i].setsubTitleName(subTitle_list[i]);
                m_orders.add(o[i]);
            }
        }
    }

    this.m_adapter = new OrderAdapter(this, R.layout.search_row, m_orders);
    lv.setAdapter(this.m_adapter);
    m_adapter.notifyDataSetChanged();
    //getOrders();

    //lv1.setAdapter(new ArrayAdapter<String>(SearchActivity.this,R.layout.search_layout , arr_sort));
}