public class MessageContainerMapper implements RowMapper<MessageContainer> {

    @Override
    public MessageContainer mapRow(ResultSet rs, int rowNum) throws SQLException {
        MessageContainer mc = new MessageContainer();
        mc.setId(rs.getInt("id"));
        mc.setName(rs.getString("name"));
        return mc;
    }

}