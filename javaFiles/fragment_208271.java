@XmlRootElement(name = "ConsumerInfo")
class DemoCustomer {


    @get:XmlElement(name = "FirstName")
    var firstName: String? = null

    @get:XmlElement(name = "LastName")
    var lastName: String? = null
}