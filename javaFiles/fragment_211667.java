for(int i = 1; i < 13; i++){
    String str = Integer.toString(i);
    mRef.child("calendar").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            String start_date = (String) dataSnapshot.child("start_date").getValue();
            String end_date = (String) dataSnapshot.child("end_date").getValue();

            try {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("start_date", start_date);
                jsonObject.put("end_date", end_date);

                Log.d("obje", "" + jsonObject);

                array.put(jsonObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            Log.d("start_date", start_date);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}