FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
DocumentReference codesRef = rootRef.collection("CodeClinic").document("Codes");
codesRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            List<String> list = new ArrayList<>();
            Map<String, Object> map = task.getResult().getData();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(entry.getKey());
                Log.d("TAG", entry.getKey());
            }
            //Do what you want to do with your list
        }
    }
});