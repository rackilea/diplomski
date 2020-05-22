Map<String, Object> values = new HashMap<>();
values.put("height", height);
values.put("weight", weight);
FirebaseDatabase.getInstance().getReference("Users")
       .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
       .updateChildren(values)