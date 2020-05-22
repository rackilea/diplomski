listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HomeItem homeItem = (HomeItem) adapter.getItem(position);
        final Dialog dialog = new Dialog(databaseFightCard.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        WindowManager.LayoutParams lp = (dialog.getWindow().getAttributes());
        lp.dimAmount = 0.5f;
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        LayoutInflater inflater = (LayoutInflater) databaseFightCard.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       RelativeLayout relative = (RelativeLayout) inflater.inflate(R.layout.custom_dialog, null, false);

        dialog.setContentView(relative);

        Button play = (Button) relative.findViewById(R.id.bPlay);
        Button done = (Button) relative.findViewById(R.id.bDone);
        TextView rn = (TextView) relative.findViewById(R.id.tvRName);
        TextView ra = (TextView) relative.findViewById(R.id.tvRAge);
        TextView rr = (TextView) relative.findViewById(R.id.tvRRecord);
        TextView rh = (TextView) relative.findViewById(R.id.tvRHeight);
        TextView rw = (TextView) relative.findViewById(R.id.tvRWeight);
        TextView rc = (TextView) relative.findViewById(R.id.tvRCity);
        TextView re = (TextView) relative.findViewById(R.id.tvRExp);
        TextView bn = (TextView) relative.findViewById(R.id.tvBName);
        TextView ba = (TextView) relative.findViewById(R.id.tvBAge);
        TextView br = (TextView) relative.findViewById(R.id.tvBRecord);
        TextView bh = (TextView) relative.findViewById(R.id.tvBHeight);
        TextView bw = (TextView) relative.findViewById(R.id.tvBWeight);
        TextView bc = (TextView) relative.findViewById(R.id.tvBCity);
        TextView be = (TextView) relative.findViewById(R.id.tvBExp);


        rn.setText(homeItem.getHomeItemRedName()+"");
        ra.setText(homeItem.getHomeItemRedAge()+"");
        rr.setText(homeItem.getHomeItemRedRecord()+"");
        rh.setText(homeItem.getHomeItemRedHeight()+"");
        rw.setText(homeItem.getHomeItemRedWeight()+"");
        rc.setText(homeItem.getHomeItemRedCity()+"");
        re.setText(homeItem.getHomeItemRedExp()+"");
        bn.setText(homeItem.getHomeItemBlueName()+"");
        ba.setText(homeItem.getHomeItemBlueAge()+"");
        br.setText(homeItem.getHomeItemBlueRecord()+"");
        bh.setText(homeItem.getHomeItemBlueHeight()+"");
        bw.setText(homeItem.getHomeItemBlueWeight()+"");
        bc.setText(homeItem.getHomeItemBlueCity()+"");
        be.setText(homeItem.getHomeItemBlueExp()+"");
        dialog.setContentView(relative);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add the play intent here
                dialog.dismiss();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
            dialog.show();

    }
});