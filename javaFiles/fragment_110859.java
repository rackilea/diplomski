public Dossie procuraPorCPF(String cpf) {

    ExecutorService executor = Executors.newFixedThreadPool(3);

    Future<String> cnh = executor.submit(() -> detectaClientCnh.verificaCNH(cpf));
    Future<String> fotoCnh = executor.submit(() -> detectaClientCnhFoto.verificaFotoCNHPorCpf(cpf));
    Future<String> pm =
        executor.submit(() -> consultaPMWService.getPMPorCPF(cpf).getProcuraPMPorCPFResult());

    Dossie dossie = new Dossie();

    try {
      dossie.setCnh(cnh.get());
      dossie.setFotoCnh(fotoCnh.get());
      dossie.setPm(pm.get());
    } catch (InterruptedException | ExecutionException cause) {
      cause.printStackTrace();
    }
    executor.shutdown();
    return dossie;
  }