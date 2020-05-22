Double meanDiff = clients.stream()
    .map(client -> client.getResults())
    .filter(results -> results.size() >= 2) // <-- keep these only
    .map(results -> {
        Score first = results.get(0);
        Score last = results.get(results.size() - 1);
        return last.value - first.value;
    })
    .collect(Collectors.averagingDouble(it -> it));