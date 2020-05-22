@Override
    public View getView(final int position, View convertView, ViewGroup arg2) {
        // TODO Auto-generated method stub
        View myView = convertView;
        final ViewHolder holder;
        try {

            if (myView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                myView = inflater.inflate(R.layout.row_affiliates_list, null);
                holder = new ViewHolder();

                holder.txtAffiliateHeader = (TextView) myView.findViewById(R.id.txtAffiliateHeader);

                holder.rlMain = (RelativeLayout) myView.findViewById(R.id.rlMain);
                holder.viewLine = (TextView) myView.findViewById(R.id.viewLine);

                myView.setTag(holder);
            } else {
                holder = (ViewHolder) myView.getTag();
            }
            holder.txtAffiliateHeader.setText(""+ AffiliatesList.get(position).getStrAffiliateTitle());

            holder.rlMain.setTag(position);
            holder.rlMain.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int arg2 = Integer.parseInt(v.getTag().toString());

                    Intent intent = new Intent(context, SecondActivity.class);
                    context.startActivity(intent);
                }
            });

            return myView;
        } catch (Exception e) {
            return myView;
        }
    }