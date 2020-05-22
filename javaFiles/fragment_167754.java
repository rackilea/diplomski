final int j = i;
textViews1[j].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (textViews2[j].getVisibility() == View.VISIBLE) {
                textViews2[j].setVisibility(View.INVISIBLE);
            }else{
                textViews2[j].setVisibility(View.VISIBLE);
            }
        }
    });