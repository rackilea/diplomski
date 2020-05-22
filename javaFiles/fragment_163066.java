descriptions.entrySet().stream()
    .map(e -> {
         int id = e.getKey();

         String description = e.getValue();
         Double price       = prices    .get(id);
         Double quantity    = quantities.get(id);
         String currency    = currencies.get(id);

         return new FinalObject(description, price, quantity, currency);
    });