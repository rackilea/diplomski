List<Client> clients = clientRepository.findAll();

Double meanDiff = clients.stream()
    .map(client -> {
        List<Result> results = client.getResults();
        if (results.size() >= 2) {
            Score first = results.get(0);
            Score last = results.get(results.size() - 1);
            return last.value - first.value;
        } else {
           return 0.0;
        }
    })
    .collect(Collectors.averagingDouble(it -> it));