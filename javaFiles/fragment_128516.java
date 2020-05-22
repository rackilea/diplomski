final DatabaseReference offsetRef = 
FirebaseDatabase.getInstance().getReference(".info/serverTimeOffset");
    offsetRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            long offset = snapshot.getValue(Long.class);
            long estimatedServerTimeMs = System.currentTimeMillis() + offset;
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
            Date resultdate = new Date(estimatedServerTimeMs);
            Log.d(Tag,"date from firebase is "+sdf.format(resultdate).toString());
        }

        @Override
        public void onCancelled(DatabaseError error) {
            System.err.println("Listener was cancelled");
            Log.d(Tag,"error is "+error.toString());
        }
    });