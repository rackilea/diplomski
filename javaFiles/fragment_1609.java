TableLayout statusTableLayout = (TableLayout)findViewById(R.id.statusDisciplineTable_layout);
        for(int i=0;i<2;i++)
        {
            LinearLayout statusTableRow = new LinearLayout(this);
            statusTableRow.setId(i);
            statusTableRow.setOrientation(LinearLayout.VERTICAL);
            TextView productsTextView = new TextView(this);
            productsTextView.setText("product name:"+i);
            statusTableRow.addView(productsTextView);
            //statusTableRow.setBackgroundColor(Color.BLACK);


            for(int j=0;j<2;j++)
            {
                RelativeLayout statusRelativelayout = new RelativeLayout(this);

                RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                rl.setMargins(0, 0, 16, 0);
                rl.addRule(RelativeLayout.ALIGN_LEFT);
                    TextView label = new TextView(this);
                label.setId(j);
                label.setText("abcd:"+j);
                label.setLayoutParams(rl);
            statusRelativelayout.addView(label);
            statusTableRow.addView(statusRelativelayout);   

            }
            statusTableLayout.addView(statusTableRow);}