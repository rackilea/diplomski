showCorporate = (Button) findViewById(R.id.individualEmail);
        showCorporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] location = corporateLocation.split(",");
                double lat, lng;
                try{
                    lat = fetchDouble(location[0], true);
                    lng = fetchDouble(location[1], false);
                    Log.d("Co-Ordinates",""+lat+", "+lng);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    String data = String.format("geo:%s,%s", lat, lng);
                    intent.setData(Uri.parse(data));
                    startActivity(intent);
                }catch (NullPointerException npe){
                    Toast.makeText(SingleCorporate.this, "Sorry No Location Available!", Toast.LENGTH_SHORT).show();
                }
            }
        });