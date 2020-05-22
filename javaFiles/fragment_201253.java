if(Pref_Storage.checkDetail(context, pid)){
        holderForGrid.AddtoCart.setText("Remove");
    }
    else{
        holderForGrid.AddtoCart.setText("Add to Cart");
    }

    holderForGrid.AddtoCart.setTag(position);
    holderForGrid.AddtoCart.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            int pos = (int) v.getTag();
            Button btn=(Button)v;

            if (btn.getText().equals("Add to Cart")) {
                catalogList.get(position).setAdded(true);
                btn.setText("Remove");
                btn.setBackgroundResource(R.drawable.btnred);
                Pref_Storage.setDetail(context, pid, "added");
            } else if (btn.getText().equals("Remove")) {

                catalogList.get(position).setAdded(false);
                btn.setBackgroundResource(R.drawable.buttonsignup);
                btn.setText("Add to Cart");
                Pref_Storage.deleteKey(context,pid);
            }
        }
    });