try (
  Connection connection = dataSource.getConnection();
  PreparedStatement preparedStatement = ...
)
{
  ...
}