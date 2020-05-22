DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users").child("Field 1");
Map<String, Object> updates = new HashMap<String,Object>();
updates.put("email", newemail);
updates.put("name", newname);

ref.updateChildren(updates);