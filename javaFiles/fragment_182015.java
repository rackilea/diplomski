class ConnectionFactory {
  List<Connection> createdInstances;

  Connection createInstance(Socket socket) {
    Connection instance = new Connection(socket);
    createdInstances.add(instance);
    return instance;
  }
}