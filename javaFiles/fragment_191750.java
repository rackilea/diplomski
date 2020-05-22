//int prevId = 0;
    for(int i = 0; i < data.size(); i++) {
        Button btn = new Button(this);
        btn.setText(data.get(i).substring(0, data.get(i).indexOf(',')));
        btn.setWidth((int) px);
        btn.setId(i+1);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            if(i = 0) {
                params.addRule(RelativeLayout.BELOW, findViewById(R.id.addClass).getId());
                layout.addView(btn, params);

            } else {
                params.addRule(RelativeLayout.BELOW, i);
                layout.addView(btn, params);
            }

        }