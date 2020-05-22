public class LawSuiteDatastore extends Thread implements ILawSuiteEE {

    private int port;
    private int trials;
    private boolean ready;
    private Process process;
    private ILawSuiteEE stub;

    public LawSuiteDatastore() {
        this.setName("K+: Remote-Datastore-Connection");
        this.port = RemoteDatastoreService.cport++;
    }

    @Override
    public void run() {
        try {
            Tools.log(RemoteDatastoreService.class, Level.INFO, "Starting RMI registry on port "+port+" for connecting to LawSuiteEE server instance.");
            this.process = Runtime.getRuntime().exec(new String[] {"java", "-jar", Context.getWorkingDirectory()+"/lib/LawSuiteSX.jar", Integer.toString(port), "LawSuiteEE"});
            //<editor-fold defaultstate="collapsed" desc="Redirect Error Stream">
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        try(DataInputStream in = new DataInputStream(process.getErrorStream())) {
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            String line;
                            while((line=br.readLine())!=null) {
                                Tools.log(RemoteDatastoreService.class, Level.SEVERE, line);
                            }
                        }
                    } catch(Exception ex){
                        Tools.log(MgmtCenterDatastore.class, Level.SEVERE, ex.getMessage());
                    }
                }
            }).start();
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Redirect Output Stream">
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        try(DataInputStream in = new DataInputStream(process.getInputStream())) {
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            String line;
                            while((line=br.readLine())!=null)   {
                                if(line.contains("SIGNAL[READY]")) { ready=true; }
                                Tools.log(RemoteDatastoreService.class, Level.INFO, line);
                            }
                        }
                    } catch(Exception ex){
                        Tools.log(MgmtCenterDatastore.class, Level.SEVERE, ex.getMessage());
                    }
                }
            }).start();
            //</editor-fold>
            // keep thread alive as long process is alive
            if(process.waitFor()>0) {
                // port was already bound
                if(process.exitValue()==2) {
                    // try it with a different port and start over again
                    if(trials<3) {
                        process = null;
                        port = ++RemoteDatastoreService.cport;
                        trials++;
                        if(trials<3) {
                            start();
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Tools.log(RemoteDatastoreService.class, Level.SEVERE, ex.getMessage());
        } catch (InterruptedException ex) {
            Tools.log(RemoteDatastoreService.class, Level.SEVERE, ex.getMessage());
        }
    }

    public boolean isReady() {
        return ready;
    }

    public int getTrials() {
        return trials;
    }

    @Override
    public void connect(RemoteDatastore datastore) throws RemoteException {
        try {
            Tools.log(RemoteDatastoreService.class, Level.INFO, "Locating RMI registry on port "+port+" for connecting to LawSuiteEE server instance.");
            Registry registry = LocateRegistry.getRegistry(port);
            stub = (ILawSuiteEE)registry.lookup("LawSuiteEE");
            stub.connect(datastore);
        } catch (NotBoundException ex) {
            Logger.getLogger(RemoteDatastoreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void disconnect() throws RemoteException {
        if(process!=null && stub!=null) {
            stub.disconnect();
            process.destroy();
        } else {
            throw new RemoteException("Remote RMI server is not ready.");
        }
    }

    @Override
    public boolean login(String username, char[] password) throws RemoteException {
        if(process!=null && stub!=null) {
            return stub.login(username, password);
        } else {
            throw new RemoteException("Remote RMI server is not ready.");
        }
    }

}