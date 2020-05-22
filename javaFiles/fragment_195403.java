docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                Map<String, Object> map = document.getData();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Map<String, Object> m = (Map<String, Object>) entry.getValue();
                    StringBuilder s = new StringBuilder();
                    for (Map.Entry<String, Object> e : m.entrySet()) {
                        s.append(e.getValue() + " ");
                    }
                    Log.d(TAG, s.toString());
                }
            }
        }
    }
});