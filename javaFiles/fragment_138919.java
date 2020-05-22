ImageView image = new ImageView(this); 
            image.setImageResource(R.drawable.app_icon);
            image.setId(counterOfReceipts);
            myLinearlayout.addView(image);
            image.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d("Activity", String.valueOf(v.getId()));

            }
            });