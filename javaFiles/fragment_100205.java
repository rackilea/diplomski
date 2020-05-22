String payload = response.readAsString();               
    try{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(payload);
        JsonNode vaultsNode = root.path("responseData").path("vaults");
        ...