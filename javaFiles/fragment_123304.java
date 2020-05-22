public void createUserInDb(String userName){
    String interned = userName.intern();
    synchronized (interned) {
        SQLHelper.insertUser(interned);
    }
}