ListAdapter adapter = new SimpleAdapter(this, dataList,
            R.layout.list_item,
            new String[] {  TAG_GRPNAME, TAG_QNT, TAG_BUDGET, TAG_STOCK, TAG_DIFF, TAG_DIFF_P, },
            new int[] {
                     R.id.l2, R.id.l3, R.id.l4, R.id.l5, R.id.l6, R.id.l7}){
         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             View v = convertView;
             if (v == null) {
                 LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 v = vi.inflate(R.layout.list_item, null);
             }
              text1 = (TextView) v.findViewById(R.id.l7);

              String rgbColor=  dataList.get(position).get(TAG_COLOR);
              String[] ARGB = rgbColor.split(" ");     
              a=Integer.parseInt(ARGB[0]);
              r=Integer.parseInt(ARGB[1]);
              g=Integer.parseInt(ARGB[2]);
              b=Integer.parseInt(ARGB[3]);                        
              text1.setBackgroundColor(Color.rgb(r, g, b));
              return super.getView(position, v, parent);
          }

     };