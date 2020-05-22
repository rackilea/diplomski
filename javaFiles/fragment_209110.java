public void serializationJackson(){
    Contact contact = new Contact()
    contact.name = 'John'
    contact.registration = Date.parse('dd/MM/yyyy', '20/10/2011')

    com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

    String jsonData = mapper.writeValueAsString(contact)
    println(jsonData)

    Contact reloadContact = mapper.readValue(jsonData, Contact.class)
}