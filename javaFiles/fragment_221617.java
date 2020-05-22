private void validateToken(String token, final ContainerRequestContext requestContext) throws Exception {

    final CountDownLatch latch = new CountDownLatch(1);

    FirebaseAuth.getInstance().verifyIdToken(token)
            .addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
                @Override
                public void onSuccess(FirebaseToken decodedToken) {
                    System.out.println("on success");
                    latch.countDown();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("on fail " + e);
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                    latch.countDown();
            }
        });
    latch.await();
}