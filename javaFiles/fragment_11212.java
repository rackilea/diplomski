Try something like:


mDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
    HashMap<String,Object> usermap = new HashMap<>(); // if you have data in diff data types go for HashMap<String,Object> or you can continue with HashMap<String,String>
    usermap.put("name",name);
    usermap.put("description",description);
    usermap.put("address",address);
    mDatabase.updateChildren(usermap); // Replace this line in your code to update.