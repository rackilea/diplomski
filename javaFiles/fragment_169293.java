dbRef.collection("Shopkeeper Own Shops").document("Shopkeeper@gmail.com").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                List<String> list = new ArrayList<>();

                Map<String, Object> map = document.getData();
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        list.add(entry.getValue().toString());
                    }
                }

                //So what you need to do with your list
                for (String s : list) {
                    Log.d("TAG", s);
                }
            }
        }
    }
});