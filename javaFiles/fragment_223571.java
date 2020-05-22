@RequestMapping(value = "/users", method = RequestMethod.DELETE)
public DeferredResult<String> deleteUser(@RequestHeader("Authentication") String token) {
    final DeferredResult<String> result = new DeferredResult<>();

    FirebaseUtil.getUid(token, new OnSuccessListener<FirebaseToken>() {
        @Override
        public void onSuccess(FirebaseToken decodedToken) {
            String uid = decodedToken.getUid();
            User userToDelete = userDao.get(uid);
            userDao.delete(uid);
            clearUserAccounts(userToDelete);
            result.setResult(uid + " was deleted");
        }
    }, new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            result.setErrorResult(e);
        }
    });

    return result;
}