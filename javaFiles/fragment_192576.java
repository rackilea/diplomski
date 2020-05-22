for( ClientSocket client : clients )
{
  if ( !client.equals(excludedClient) && client.session.isOpen() )
  {
    // Broadcast...
  }
}