Foo foo = template.queryForObject(SQL, new RowMapper<Foo>(){
        @Override
        public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Foo foo = new Foo();
            foo.setName(rs.getString("name"));
            foo.setIntegers(Arrays.asList((Integer[]) rs.getArray("item_list").getArray()));
            return foo;
        }
    });