String link = "https://query2.finance.yahoo" +
            ".com/v7/finance/options/AEIS?formatted=true&lang=en-US&region=US&corsDomain=finance.yahoo.com";
ObjectMapper mapper = new ObjectMapper();
JsonNode jsonNode = mapper.readTree(new URL(link));
JsonNode calls = jsonNode.findValue("calls");
List<Option> callOptions = mapper.readValue(calls.traverse(), new TypeReference<List<Option>>() {});