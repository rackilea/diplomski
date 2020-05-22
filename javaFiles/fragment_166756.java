public static Result apiCustomers(){
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);

        List<Customer> customerList = Model.coll(Customer.class).find().toArray();

        for(Customer c : customerList){
            ObjectNode mail = Json.newObject();
            mail.put("email", c.email);
            arrayNode.add(mail);
        }

        return ok(arrayNode);
}