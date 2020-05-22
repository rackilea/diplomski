ListView list= (ListView) getActivity().findViewById(R.id.list);
ListAdapter adapter = 
   new MyAdapter(
            getActivity(),
            orderList,
            R.layout.order_usa_row,
            new String[]{TAG_PRICE,TAG_TITLE,TAG_PSTATUS,TAG_PRICESYMBOL},
            new int[]{R.id.price,R.id.title,R.id.pstatus,R.id.symbol});
 list.setAdapter(adapter);