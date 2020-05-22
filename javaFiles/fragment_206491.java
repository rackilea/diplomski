Task t1 = Query1.get();
Task t2 = Query2.get();
Task t3 = Query3.get();
Task t4 = Query4.get();

Task combinedTask = Tasks.whenAllSuccess(t1, t2, t3, t4).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
    @Override
    public void onSuccess(List<Object> list) {
         //Do what you need to do with your list
    }
});