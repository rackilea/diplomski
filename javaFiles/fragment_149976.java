interface ISafeExecute<T> {

  void execute(IDfSession session);

  T getResult();

  Exception getException();

}

mySafeExecute.execute(session);

if(mySafeExecute.getException() == null) {
    return mySafeExecute.getResult();
} else {
    // runtime exception or declaration in method
    // signature
    throw new RuntimeException(mySafeExecute.getException());
}