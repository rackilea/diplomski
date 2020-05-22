@XStreamAlias("root")
class RootElement
{
    @XStreamAsAttribute
    final String xmlns = "http://www.example.org"

    @XStreamAsAttribute 
    @XStreamAlias("xmlns:xlink")
    final String xlink="http://www.w3.org/1999/xlink"

    SomeElement someElement
}

class SomeElement
{
    @XStreamAsAttribute 
    @XStreamAlias("xml:id")
    String id

    @XStreamAsAttribute 
    @XStreamAlias("xlink:href")
    String href
}