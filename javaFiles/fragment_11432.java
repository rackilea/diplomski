class ClientThread extends Thread {

    private List<Double> vector;

    public ClientThread(List<Double> vectorArg) {
        vector = vectorArg;
    }

    @Override
    public void run() {
        try {
            Service s = (Service) Naming.lookup("rmi://localhost:1099/Servico");
            System.out.println("get(1): " + vector.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}