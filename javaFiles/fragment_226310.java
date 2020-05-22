Envelope envelope = new Envelope();
envelope.setNewVariable(true);
envelope.setProducts(products);

Gson gson = new Gson();
String jsonInString = gson.toJson(envelope);