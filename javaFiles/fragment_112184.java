// export for RMI
IRemote remoteObject = new RemoteObject();
IRemote stub = (IRemote) UnicastRemoteObject.exportObject(remoteObject, 0);

// bind to registry so clients can find it
Registry registry = LocateRegistry.createRegistry(port);
registry.bind(bindingName, stub);

// unexport
UnicastRemoteObject.unexportObject(remoteObject, true);