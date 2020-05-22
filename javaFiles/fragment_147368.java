public void appLeave(IClient client, IScope app)
  {
    for(Iterator e = users.iterator(); e.hasNext();)
        {
        User user = (User) e.next();
        IConnection conn = user.conn;
        ((IServiceCapableConnection) conn).invoke("DisconnectedUser");  
    }
  }