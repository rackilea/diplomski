HashMap hashMap = new HashMap();

SharedPreferences sp = getSharedPreferences("Mypref", 0);
hashMap.put("first_name", sp.getString("first_name", null))
hashMap.put("last_name", sp.getString("last_name",null))
hashMap.put("fathers_name", sp.getString("fathers_name", null))
hashMap.put("date", sp.getString("date", null))
hashMap.put("income", sp.getString("income", null))
(.......)

Iterator iterator = hashMap.entrySet().iterator() 
if (hashMap.hasNext()) {
    iterator.next() 
    reference.child("User").child(Objects.requireNonNull(mAuth.getUid())).child(iterator.getKey).setValue(iterator.getValue);
}