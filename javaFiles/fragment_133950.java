class CustomValueListener implements ValueEventListener {    
    private volatile DataSnapshop data; //accessed from multiple threads
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        data = snapshot;
    }    
    @Override
    public void onCancelled(FirebaseError firebaseError) {}
    public DataSnapshot getLatestData() {
        return data;
    }
}
private CustomValueListener listener = new CustomValueListener();

public static void main(String...args) {
     ...     
     Firebase fb = new Firebase("https://----.firebaseio.com/");
     Query q = fb.orderByKey();    
     q.addValueEventListener(listener);
     ...
}
String[] yourMethod() {
     ...
     Sring[] result = ...
     DataSnapshot snapshot = listener.getLatestData();
     if (snapshot != null) {
        iterator = snapshot.getChildren().iterator();
         while (iterator.hasNext()) {
            //now you can copy the data into the array 
         }
     }
     return result;
}