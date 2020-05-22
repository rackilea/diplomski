public void serializationGson(){
    Contact contact = new Contact()
    contact.name = 'John'
    contact.registration = Date.parse('dd/MM/yyyy', '20/10/2011')

    Gson gson = new Gson()

    String jsonData = gson.toJson(contact)
    println(jsonData)

    Contact reloadContact = gson.fromJson(jsonData, Contact.class)

    println(jsonData)
}