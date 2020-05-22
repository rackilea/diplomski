protect_me_btn.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            pbupdate.setVisibility(4);
            String lat= Double.toString(latitude);
            Intent inte=new Intent(getApplicationContext(), set_alaram.class);
            Bundle lati=new Bundle();
            lati.putString("first",lat);
            lati.putDouble("lat", latitude); //<< send double using putDouble
            inte.putExtras(lati);
            startActivity(inte);                    
        }
    });