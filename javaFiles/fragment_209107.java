public void serializationNative(){
    Contact contact = new Contact()
    contact.name = 'John'
    contact.registration = Date.parse('dd/MM/yyyy', '20/10/2011')

    def sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    sdf.setTimeZone(TimeZone.getTimeZone('UTC'))
    JsonOutput.dateFormatter.set(sdf)
    String jsonData = JsonOutput.toJson(contact)
    println(jsonData)

    JsonSlurper slurper = new JsonSlurper().setType( JsonParserType.INDEX_OVERLAY )
    def object = slurper.parseText(jsonData)
    Contact reloadContact = new Contact(object)
}