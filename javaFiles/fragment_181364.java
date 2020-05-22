List<String> result = dest
        .stream()
        .filter(x -> x.startsWith("WAW"))
        .map(x -> {
            String[] row = x.split(" ");

            return String.format("to %s - price in EUR:    %s",
                    row[1],
                    Integer.parseInt(row[2]) * ratePLNvsEUR);
        })
        .collect(Collectors.toList());