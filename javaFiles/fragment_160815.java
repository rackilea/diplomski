@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RootClass", propOrder = {
        "parentClass"
})
public class RootClass {
    @XmlElements({
            @XmlElement(name = "ChildAClass", type = ChildAClass.class),
            @XmlElement(name = "ChildBClass", type = ChildBClass.class)
    })
    protected ParentClass parentClass;

 ... getters and setters
}



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParentClass", propOrder = {
        "parentField"
})
public class ParentClass{
    @XmlElement(name = "ParentField")
    protected String parentField;

 ... getters and setters
}


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChildAClass", propOrder = {
        "childAfield"
})
public class ChildAClass extends ParentClass{

    @XmlElement(name = "ChildAfield")
    protected String childAfield;

 ... getters and setters
}


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChildBClass", propOrder = {
        "childBfield"
})
public class ChildBClass extends ParentClass{

    @XmlElement(name = "ChildBfield")
    protected String childBfield;

 ... getters and setters
}