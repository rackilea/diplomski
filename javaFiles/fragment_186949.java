int i = 0;

mDatabaseref = FirebaseDatabase.getInstance().getReference().child("location").child(uid);
String device_token = FirebaseInstanceId.getInstance().getToken();

HashMap<String, String> userMap = new HashMap<>();
userMap.put("Startlatitude", String.valueOf(lat));
userMap.put("Startlongitude" , String.valueOf(lng));
userMap.put("Currentlatitude" , String.valueOf(lat));
userMap.put("Currentlongitude" , String.valueOf(lng));

if(i==0) {

    userMap.put("device_token", device_token);
    mDatabaseref.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            Toast.makeText(getApplicationContext() , "Location updated" , Toast.LENGTH_SHORT ).show();
            i++;
        }
    });
}
else {
    userMap.child("Currentlatitude").setValue(String.valueOf(lat));
    userMap.child("Currentlongitude").setValue(String.valueOf(lng));

    // Attach addOnCompleteListener
    // You  can also use HashMap to update both together.
}