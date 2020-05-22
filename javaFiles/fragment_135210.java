final int greenBackgroundColor = ContextCompat.getColor(this, R.color.my_red_color);
    final int redBackgroundColor = ContextCompat.getColor(this, R.color.my_green_color);
    switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b){
                cardView.setCardBackgroundColor(greenBackgroundColor);
            }
            else{
                cardView.setCardBackgroundColor(redBackgroundColor);
            }

        }
    });