@ApiMethod(name = "serverAuth")
public MyUser serverAuth(@Named("token") String token) {
    final List<MyUser> users = new ArrayList<>();
    final CountDownLatch cdl = new CountDownLatch(1);
    FirebaseAuth.getInstance().verifyIdToken(token)
            .addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
                @Override
                public void onSuccess(FirebaseToken decodedToken) {
                    // ... init uid, email, name and claimString
                    users.add(new MyUser(uid, email, name, claimString));
                    cdl.countDown();
                }
            });
    try {
        cdl.await(); // This line blocks execution till count down latch is 0
    } catch (InterruptedException ie) {

    }
    if (users.size() > 0) {
        return users.get(0);
    } else {
        return null ;
    }
}