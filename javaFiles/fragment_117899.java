Function.create(db.getConnection(), "getNickName", new Function() {
    protected void xFunc() throws SQLException {
        String name = value_text(0);
        String nickName = ...; // implement myparsingfunction here
        result(nickName);
    }
});