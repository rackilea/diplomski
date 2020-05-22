@Override
public void batchUpt2(User_FK users) {
    long startTime = System.nanoTime();

    jdbcTemplate.update("INSERT INTO INS_RAZNO.BULK_TEST VALUES (?, ?, ?)", new PreparedStatementSetter() {

        @Override
        public void setValues(PreparedStatement ps) throws SQLException {
            int x;
            for(x = 0; x < users.getUser().size(); ++x) {

            ps.setInt(1, x);
            ps.setLong(2, users.getUser().get(x));
            ps.setInt(3, users.getSys());

        }
        }

    });
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000;

    System.out.println("-------------"+duration+"-----------------forEach");

}