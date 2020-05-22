string conn = "Provider=PervasiveOLEDB;  Data Source=gescoop°2018;Location=<url>";
string queryString = "select * from TAB_UTENTI";

try
{
    using (OleDbConnection connection = new OleDbConnection(conn))
    {
        OleDbCommand command = new OleDbCommand(queryString, connection);
        connection.Open();
        OleDbDataReader reader = command.ExecuteReader();

        while (reader.Read())
        {
            Debug.WriteLine(reader.GetValue(0).ToString() + "  " +
                reader.GetValue(1).ToString() + "  " +
                ...
                reader.GetValue(47).ToString() + "  ");
        }
        reader.Close();
    }
}
catch (Exception ex)
{
    Debug.WriteLine("Failed to connect to data source " + ex.Message);
}