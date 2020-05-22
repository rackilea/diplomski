String pricex = psp.getQuanntity();
                int xx = Integer.parseInt(pricex);
                int total = xx + 1;
                String totalx = Integer.toString(total);
    handler.qty.setText(totalx);

     handler.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    
                //add
                psp.setQuantity(yourQuantity++);
                notifyDataSetChanged();
              }
        });

 handler.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    
                //add
                psp.setQuantity(yourQuantity--);
                notifyDataSetChanged();
              }
        });