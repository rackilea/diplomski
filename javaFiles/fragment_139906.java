public class NotificationPayloadArgument implements Argument {
  private NotificationPayload payload;

  NotificationPayloadArgument(NotificationPayload payload) {
      this.payload = payload;
  }

  @Override
  public void apply(int i, PreparedStatement preparedStatement, StatementContext statementContext)
    throws SQLException {
      preparedStatement.setString(i, toString());
  }

  @Override
  public String toString() {
      return new JSONObject(payload).toString();
  } 

}