public void serializationBoon(){
    Contact contact = new Contact()
    contact.name = 'John'
    contact.registration = Date.parse('dd/MM/yyyy', '20/10/2011')

    ObjectMapper mapper = JsonFactory.create()

    String jsonData = mapper.toJson(contact)
    println(jsonData)

    Contact reloadContact = mapper.fromJson(jsonData, Contact.class)
}