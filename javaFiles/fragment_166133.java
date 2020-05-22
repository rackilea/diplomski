@Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
        Intent intent = new Intent(Hotel.this, MapsActivity.class);
        Object lan = item_detail.get(position).lon;
        Object lat = item_detail.get(position).lat;
        if (lan == null || lat == null){
            //show toast
        } else {
            intent.putExtra("lon", lon);
            intent.putExtra("lat", lat);
            Hotel.this.startActivity(intent);
        }
    }