final LayoutInflater lyInflater= (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
LinearLayout lLayoutRow = (LinearLayout) lyInflater.inflate(
                R.layout.table_row_layout, null);

TextView tv1 = (TextView) lLayoutRow.findViewById(R.id.rowTv1);
TextView tv2 = (TextView) lLayoutRow.findViewById(R.id.rowTv2);
TextView tv3 = (TextView) lLayoutRow.findViewById(R.id.rowTv3);
TextView tv4 = (TextView) lLayoutRow.findViewById(R.id.rowTv4);