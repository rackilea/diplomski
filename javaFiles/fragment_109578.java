List<String> tokens = new ArrayList<>();
        Action analyze = new Analyze.Builder().source("apple").build();
        JestResult result = client.execute(analyze);
        if (result.isSucceeded()) {
            JsonElement tokenElement = result.getJsonObject().get("tokens");
            if (tokenElement != null) {
                JsonArray tokens = tokenElement.getAsJsonArray();
                for (int i = 0; i < tokens.size(); i++) {
                    tokens.add(tokens.get(i).getAsJsonObject().get("token").getAsString());
                }
            }
        }
        return tokens;