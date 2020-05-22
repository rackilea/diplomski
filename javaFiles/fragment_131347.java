private bool PushDataToQueue(byte[] data, string queueName, ref string error)
{
    try
    {
        if (_connection == null || !_connection.IsOpen)
            _connection = _factory.CreateConnection();

        using (IModel channel = _connection.CreateModel())
        {
            if (AutoCloseConnection)
                _connection.AutoClose = AutoCloseConnection;
            // Set the AutoDelete as false, fourth parameter!!!
            channel.QueueDeclare(queueName, true, false, false, null);
            channel.BasicPublish("", queueName, null, data);
            if (!channel.IsClosed)
                channel.Close();
        }
    }
    catch (Exception e)
    {
        error = string.Format("Failed pushing data to queue name '{0}' on host '{1}' with user '{2}'. Error: {3}", queueName, _factory.HostName, _factory.UserName,
            e.GetCompleteDetails());
        return false;
    }

    return true;
}