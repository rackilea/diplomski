descriptions.keySet().stream()
    .map(id -> {
         String description = descriptions.get(id);
         Double price       = prices      .get(id);
         Double quantity    = quantities  .get(id);
         String currency    = currencies  .get(id);

         return new FinalObject(description, price, quantity, currency);
    });