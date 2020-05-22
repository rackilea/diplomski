public Result searchContacts(String term) {

    List<Contact> searchedContacts = Contact.find.where()
                  .eq("firm_id", session().get("firm"))                                                               
                  .or(com.avaje.ebean.Expr.like("first_name", "%"+ term + "%"),
                  com.avaje.ebean.Expr.like("last_name",  "%" + term + "%"))
                  .findList();

    ArrayNode suggestions = Json.newArray();

    for (Contact contact : searchedContacts) {
        ObjectNode result = Json.newObject();
        result.put("value", contact.firstName + ' ' + contact.lastName);
        result.put("data", contact.id);
        suggestions.add(result);
    }

    ObjectNode output = Json.newObject();
    output.set("suggestions", suggestions);

    return ok(output);
}