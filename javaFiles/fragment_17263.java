Integer userId = jsonObject1.getInteger("userid");
if (userId==null) {
    preparedStatement1.setNull(1, Types.INTEGER);
} else {
    preparedStatement1.setInt(1, userId);
}