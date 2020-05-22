mClientesRest.getClientes(new ClientesRestListener() {
    public void clientesReceived(List<ClienteModel> clientes) {
        // Here modify to do whatever you need to do with clientes
        Log.i("RM", String.valueOf(clientes));
    }
});