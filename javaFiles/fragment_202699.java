ResultSet keys = addresser.getGeneratedKeys();
int processId = -1;
if (keys.next())
{
  processId = keys.getInt("processId");
}