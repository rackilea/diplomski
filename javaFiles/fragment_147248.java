public static void main(String args[]) {
    try {
        if(args.length==2) {
            if(args[1].equals("LawSuiteEE")) {
                ILawSuiteEE stub = (ILawSuiteEE) UnicastRemoteObject.exportObject(new LawSuiteEE(), 0);
                Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[0]));
                registry.bind("LawSuiteEE", stub);
            } else if(args[1].equals("MgmtCenterEE")) {
                ILawSuiteEE stub = (ILawSuiteEE) UnicastRemoteObject.exportObject(new MgmtCenterEE(), 0);
                Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[0]));
                registry.bind("MgmtCenterEE", stub);
            } else {
                throw new NumberFormatException();
            }
            Logger.getLogger(RemoteContext.class.getName()).log(Level.INFO, "Remote context service is listening on port "+args[0]+" for incoming requests delegating to "+args[1]+".");
            System.out.println("SIGNAL[READY]");
        } else {
            throw new NumberFormatException();
        }
    } catch (RemoteException ex) {
        System.exit(1);
    } catch (AlreadyBoundException ex) {
        System.exit(2);
    } catch(NumberFormatException ex) {
        System.exit(3);
    }