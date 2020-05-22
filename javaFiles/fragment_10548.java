final AtomicBoolean done = new AtomicBoolean(false);

databaseReference.child("someChild")
    .setValue(someObject)
    .addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            System.out.println("completed");
            done.set(true);
        }
    });

final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    if (done.get()) {
       ... Do the thing that requires the data
    }
  }
}, 1000);