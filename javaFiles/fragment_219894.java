@XmlRootElement(name="list")
public class JaxbBaseList<T> implements JaxbList<T>{
    protected List<T> list;

    public List<T> getList(){
        return list;
    }
}


public class JaxbPrimitiveList<T> extends JaxbList<T>{
    protected List<T> list;

    @XmlElement( name="item" )
    public List<T> getList(){
        return list;
    }
}

@XmlSeeAlso( Uri )
public class JaxbUriList<Uri> extends JaxbList<Uri>{
    protected List<Uri> list;

    @XmlElement( name="uri" )
    public List<Uri> getList(){
        return list;
    }
}