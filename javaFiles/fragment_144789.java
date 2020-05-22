@Override
   public View getView(int position, View view, ViewGroup viewgroup) {
         if (view == null) {
                    view=inflater.inflate(R.layout.pattern, null);
          }
          Listitem item = (Listitem)getItem(position)
          TextView tv=(TextView) view.findViewById(R.id.nameview);
          TextView tv2=(TextView) view.findViewById(R.id.pdesc);
          TextView tv3=(TextView) view.findViewById(R.id.priceView);
          tv.setText(item. pName);
          tv2.setText(""+item.pPrice);
          tv3.setText(item.pDisc);
          return view;
     }