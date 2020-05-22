final ArrayList <String> locationnew = new ArrayList <String>();
    database.orderByChild("ItemName").equalTo(name).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot){
            for(DataSnapshot suggestionSnapshot : dataSnapshot.getChildren())
            {
                itcat=suggestionSnapshot.getKey();
                String loc=suggestionSnapshot.child("ShopLocation").getValue().toString();
                names1.add(itcat);
                locationnew.add(loc);

            }
            String[] loca=new String[1000];

            for(int i=0; i < locationnew.size(); i++)
            {
                loca[i]=locationnew.get(i);
            }

            String find_lat_lan = "";
            serch2.setText(String.valueOf(loca[0]));
            String example = serch2.getText().toString();
            Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
            while(m.find()) {
                find_lat_lan = m.group(1) ;
            }

            String[] gpsVal = find_lat_lan.split(",");
            String lat=gpsVal[0];
            String lang=gpsVal[1];
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

            // Toast.makeText(getApplicationContext(), "AWW SNAP... Something is Wrong.", Toast.LENGTH_LONG).show();
        }
    });