String ratesAsJson = "{ \"EUR\" : 0.2, \"USD\":1.0 }";
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<Map<String, Double>> typeRef = new TypeReference<Map<String, Double>>() {};

    Map<String, Double> map = objectMapper.readValue(ratesAsJson, typeRef);
    List<Rate> list = map.entrySet().stream()
            .map(entry -> new Rate(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());