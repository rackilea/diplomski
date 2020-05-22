public boolean isEmailUnique(String email) {
    int count=0;
    String whereclause = "EMAIL=?";
    String[] whereargs = new String[]{email};
    Cursor csr =db.query("USER",null,whereclause,whereargs,null,null,null);
    count = csr.getCount();
    csr.close();
    return count < 1;
}