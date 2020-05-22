@Override
public void onComplete(@NonNull Task<QuerySnapshot> task) {
    if (task.isSuccessful()) {
        for (QueryDocumentSnapshot document : task.getResult()) {
            Log.i(TAG, "onComplete: " + document.get("UserId") + " => " + document.get("userText"));            
            userIdArrayList.add(document.get("UserId").toString());      
            userTextArrayList.add(document.get("userText").toString());
        }
        yourButton.setEnabled(true);
    } else {
        Log.i(TAG, "onComplete: Error getting documents", task.getException());
        yourButton.setEnabled(false);
    }
 }