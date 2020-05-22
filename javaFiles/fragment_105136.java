delete_btn=(Button)view.findViewById(R.id.delete_btn);
        delete_btn.setTag(view);
        delete_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View rowview=(View)v.getTag();
                memID_tv = (TextView)rowview.findViewById(R.id.member_id);
                memName_tv = (TextView)rowview.findViewById(R.id.member_name);

            }  
        });