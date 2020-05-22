private final RowMapper<Card> MAP_CARD_FROM_ACCOUNT = new RowMapper<Card>() {

    public void setAccount(Account account){
       this.account = account;
    }

    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = new DefaultCard(rs.getString("number"), account);
        return card;
    }

};

 private final RowMapper<Card> MAP_CARD = new RowMapper<Card>() {

    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account(rs.getLong("a.account_id"), rs.getString("a.username");
        Card card = new DefaultCard(rs.getString("c.number"), account);
        return card;
    }

};

private final RowMapper<Account> MAP_ACCOUNT = new RowMapper<Account>() {

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        SQL = "SELECT * FROM cards where account_id = " + rs.getLong("id");
        Account account = new DefaultAccount(rs.getLong("id"), rs.getString("username"));
        MAP_CARD_FROM_ACCOUNT.setAccount(account)
        List<Card> cards = template.query(SQL, MAP_CARD_FROM_ACCOUNT);
        account.setCards(cards);
        return account;
    }
};