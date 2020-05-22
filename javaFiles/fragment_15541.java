utilizadores.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
                if (map.containsKey("daniel@gmail.com")) {
                    Log.d(TAG, "User exists!");
                } else {
                    Log.d(TAG, "User does not exist!");
                }
            } else {
                Log.d(TAG, "No such document");
            }
        }
    }
});